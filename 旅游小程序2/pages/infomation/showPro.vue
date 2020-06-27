<!--产品展示-->
<template>
	<view>
		<!-- <view class="uni-title uni-common-pl">产品海报</view> -->
		<view class="uni-title uni-common-pl">旅游项目id：</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-db">
						<text style="width:auto;height: 400rpx;">{{ proId }}</text>
					</view>
				</view>
			</view>
		<view class="uni-title uni-common-pl">旅游项目名称：</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-db">
						<text style="width:auto;height: 400rpx;">{{ name }}</text>
					</view>
				</view>
			</view>
		<view class="uni-title uni-common-pl">所属公司id：</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-db">
						<text style="width:auto;height: 400rpx;">{{ companyId }}</text>
					</view>
				</view>
			</view>
		<view class="uni-title uni-common-pl">价格：</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-db">
						<text style="width:auto;height: 400rpx;">{{ price }}</text>
					</view>
				</view>
			</view>
		<view class="uni-title uni-common-pl">详细信息：</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-db">
						<rich-text style="width:auto;height: 400rpx;">{{ info }}</rich-text>
					</view>
				</view>
			</view>
		<view class="btn">
			<button style="width: 400rpx;height: auto;background-color: #416dff;" type="primary" class="primary" @tap="generateAd()">一键生成海报</button>
		</view>
	
	</view>
</template>

<script>
	export default {
		onLoad: function (event) { //option为object类型，会序列化上个页面传递的参数
			console.log(event.id); 
			this.$data.proID = event.id;
			this.$data.name = event.name;
			this.$data.companyId = event.companyId;
			this.$data.price = event.price;
			this.$data.info = event.info;
			this.$data.userID = event.userID;
			this.$data.picture = event.picture;
		},
		data() {
			return {
				proID: null,
				name: null,
				companyId: null,
				price: null,
				info:null,
				userID: null
			}
		},
		methods: {
			generateAd() {
				console.log(this.$data.picture);
				let request = '../functions/ad?userID=' + this.$data.userID + '&proID=' + this.$data.proID + 
				'&picture=' + this.$data.picture;
				uni.navigateTo({
					url:request
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
