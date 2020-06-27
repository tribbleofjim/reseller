<!--产品展示-->
<template>
	<view>
	<view class="uni-title uni-common-pl">产品海报</view>
	<view class="uni-title uni-common-pl">产品id</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					旅游项目id：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;">Id</text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">旅游项目名称：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					名称：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;">Name</text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">所属公司id：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					所属公司：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;">CompanyId</text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">价格：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					价格：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;">Price</text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">详细信息：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					信息：
				</view>
				<view class="uni-list-cell-db">
					<rich-text style="width:auto;height: 400rpx;">Info</rich-text>
				</view>
			</view>
		</view>
	<view class="uni-title uni-common-pl">销售量：</view>
		<view class="uni-list">
			<view class="uni-list-cell">
				<view class="uni-list-cell-left">
					数额：
				</view>
				<view class="uni-list-cell-db">
					<text style="width:auto;height: 400rpx;">Sale</text>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	var id
	var name
	var companyId
	var price
	var info
	var sale
	export default {
		onLoad: function (event) { //option为object类型，会序列化上个页面传递的参数
			console.log(event); 
			id = event.id;
			name = event.name;
			companyId = event.companyId;
			price = event.price;
			info = event.info;
			sale = event.sale
		},
		data() {
			return {
				iD:id,
				Name:name,
				CompanyId:companyId,
				Price:price,
				Info:info,
				Sale:sale
			}
		},
		methods: {
			payForBill:function(){
				
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
