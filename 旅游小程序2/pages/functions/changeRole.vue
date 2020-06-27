<!--成为分销商-->
<template>
	<view>
		<view class="uni-title uni-common-pl">选择角色</view>
		    <view class="uni-list">
		        <view class="uni-list-cell">
		            <view class="uni-list-cell-left">
		                当前选择
		            </view>
		            <view class="uni-list-cell-db">
		                <picker @change="bindPickerChange" :value="index" :range="array" @click="getRole($event)">
		                    <view class="uni-input">{{array[index]}}</view>
		                </picker>
		            </view>
		        </view>
		    </view>	
		<view class="uni-title uni-common-pl">输入上级id：</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-left">
						id：
					</view>
					<view class="uni-list-cell-db">
						<input class="uni-input" type="text" placeholder="请输入您的上级id!" @click="getID"/>
					</view>
				</view>
			</view>
		<view class="btn-row">
			<button style="width: 400rpx;height: auto;background-color: #416dff;" type="primary" class="primary" @tap="confirmChanges()">确认更改</button>
		</view>	
	</view>
</template>

<script>
	var ph
	var pw
	var I
	var role
	export default {
		onLoad: function (event) { //option为object类型，会序列化上个页面传递的参数
				console.log(event);
				ph = event.phonenumber;
				pw = event.password;
				console.log(ph);
				console.log(pw)
		},
		data(){
			return {
			    title: 'picker',
			    array: ['游客', '二级业务员', '分销商', '一级业务员'],
				index:0,
				inputRole:'',
				inputID:''
			}				
		},
		methods:{
			bindPickerChange: function(e) {
			    console.log('picker发送选择改变，携带值为', e.target.value)
				this.index = e.target.value
				I = e.target.value
				console.log(I)
			    role = this.array[e.target.value]
				console.log(role)
			},
			getID:function(event){
				this.inputID = event.target.value
			},
			getRole(event){
				console.log(event)
			},
			confirmChanges: function(e) {
				console.log(e);
				console.log(role)
				uni.request({
					url:'http://144.34.188.164:8080/user/opratorRegister',
					method:'POST',
					data:{
						phonenumber:ph,
						password:pw,
						role: role
					},
					success: (res) => {
						console.log(res)
						uni.navigateBack({
							delta:1,
						})
					}
				})
			}
		}
	}
</script>

<style>
	.btn-row {
		margin-top: 25px;
		padding: 10px;
	}
</style>
