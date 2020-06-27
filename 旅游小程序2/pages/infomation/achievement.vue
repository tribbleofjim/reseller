<!--业绩-->
<!--产品展示-->
<template>
	<view>
	<view class="uni-title uni-common-pl">订单号</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					id：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;"></text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">产品名称：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					proID：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;"></text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">总金额：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					tourPrice：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;"></text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">我的回馈：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					mycost：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;"></text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">公司信息：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					id：
				</view>
				<view class="uni-list-cell-db">
					<rich-text style="width:auto;height: 400rpx;"></rich-text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">从属信息：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					id：
				</view>
				<view class="uni-list-cell-db">
					<rich-text style="width:auto;height: 400rpx;"></rich-text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">游客信息：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					id：
				</view>
				<view class="uni-list-cell-db">
					<rich-text style="width:auto;height: 400rpx;"></rich-text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		onLoad: function () { //option为object类型，会序列化上个页面传递的参数
			console.log(); 
		},
		data() {
			return {
			}
		},
		methods: {
			payForBill:function(){
				
			}
		}
	}
</script>

<style>

</style>
