<!--编辑资料-->
<template>
	<view>
	    <view class="uni-title uni-common-pl">选择地区</view>
	        <view class="uni-list">
	            <view class="uni-list-cell">
	                <view class="uni-list-cell-left">
	                    当前选择
	                </view>
	                <view class="uni-list-cell-db">
	                    <picker @change="bindPickerChange1" :value="index1" :range="array1">
	                        <view class="uni-input">{{array1[index1]}}</view>
	                    </picker>
	                </view>
	            </view>
	        </view>	
	    <view class="uni-title uni-common-pl">性别</view>
	        <view class="uni-list">
	            <view class="uni-list-cell">
	                <view class="uni-list-cell-left">
	                    当前选择
	                </view>
	                <view class="uni-list-cell-db">
	                    <picker @change="bindPickerChange2" :value="index2" :range="array2" >
	                        <view class="uni-input">{{array2[index2]}}</view>
	                    </picker>
	                </view>
	            </view>
	        </view>	
		<view class="uni-title uni-common-pl">年龄</view>
			<view class="uni-list">
			    <view class="uni-list-cell">
			        <view class="uni-list-cell-left">
						当前选择
			        </view>
			        <view class="uni-list-cell-db">
			                <picker @change="bindPickerChange3" :value="index3" :range="array3" >
			                    <view class="uni-input">{{array3[index3]}}</view>
			                </picker>
			        </view>
			    </view>
			</view>	
	    <view class="uni-title uni-common-pl">出生日期</view>
	        <view class="uni-list">
	            <view class="uni-list-cell">
	                <view class="uni-list-cell-left">
	                    当前选择
	                </view>
	                <view class="uni-list-cell-db">
						<picker mode="date" :value="date" :start="startDate" :end="endDate" @change="bindDateChange">
						    <view class="uni-input">{{date}}</view>
						</picker>
	                </view>
	            </view>
	        </view>
		<view class="uni-title uni-common-pl">修改用户名</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-left">
						用户名：
					</view>
					<view class="uni-list-cell-db">
						<input class="uni-input" type="text" placeholder="请输入您的用户名!"/>
					</view>
				</view>
			</view>
		<view class="btn-row">
			<button style="width: 400rpx;height: auto;background-color: #b3fff9;" type="primary" class="primary" @tap="saveChanges()">保存更改</button>
		</view>
	</view>
</template>

<script>
	name:"EditPInfo"
	export default {
		onLoad: function () { //option为object类型，会序列化上个页面传递的参数
		      console.log(); 
		},
	    data() {
	        const currentDate = this.getDate({
	            format: true
	        })
	        return {
	            title: 'picker',
	            array1: ['jinan', 'beijing', 'shanghai', 'shenzhen'],
				array2: ['男','女'],
				array3: ['18','19','20','21','22','23','24'],
	            index1: 0,
				index2: 0,
				index3: 0,
	            date: currentDate,
	        }
	    },
	    computed: {
	        startDate() {
	            return this.getDate('start');
	        },
	        endDate() {
	            return this.getDate('end');
	        }
	    },
	    methods: {
	        bindPickerChange1: function(e) {
	            console.log('picker发送选择改变，携带值为', e.target.value)
	            this.index1 = e.target.value
	        },
			bindPickerChange2: function(e) {
			    console.log('picker发送选择改变，携带值为', e.target.value)
			    this.index2 = e.target.value
			},
			bindPickerChange3: function(e) {
			    console.log('picker发送选择改变，携带值为', e.target.value)
			    this.index3 = e.target.value
			},
	        bindDateChange: function(e) {
	            this.date = e.target.value
	        },
	        bindTimeChange: function(e) {
	            this.time = e.target.value
	        },
	        getDate(type) {
	            const date = new Date();
	            let year = date.getFullYear();
	            let month = date.getMonth() + 1;
	            let day = date.getDate();
	
	            if (type === 'start') {
	                year = year - 60;
	            } else if (type === 'end') {
	                year = year + 2;
	            }
	            month = month > 9 ? month : '0' + month;;
	            day = day > 9 ? day : '0' + day;
	            return `${year}-${month}-${day}`;
	        },
			saveChanges(){
				console.log();
				uni.request({
					url:'',
					method:'POST',
					header:{'content-type':'application/x-www-from-urlencode'},
					data:{
						
					}
				})
			}
	    },
	} 
</script>

<style>
	.conformR{
		align-items: center;
	}
	.btn-row {
		margin-top: 25px;
		padding: 10px;
	}
</style>
