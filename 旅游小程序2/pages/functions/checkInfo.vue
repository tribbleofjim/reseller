<!--查看资料-->
<template>
	<view>
		<view class="content">
		    <page-head :title="title"></page-head>
		    <view class="uni-padding-wrap">
		        <view class="uni-title uni-common-mt">
		            我的账户
		        </view>
		        <view class="uni-common-mt" style="background:#FFF; padding:40rpx;">
		            <rich-text :nodes="nodes"></rich-text>
		        </view>
		        <view class="uni-title uni-common-mt">
		            我的地区:
		        </view>
		        <view class="uni-common-mt" style="background:#FFF; padding:40rpx;">
		            <rich-text :nodes="strings"></rich-text>
		        </view>
				<view class="uni-title uni-common-mt">
				    我的身份:
				</view>
				<view class="uni-common-mt" style="background:#FFF; padding:40rpx;">
				    <rich-text :nodes="strings"></rich-text>
				</view>
				<view class="uni-title uni-common-mt">
				    我的生日:
				</view>
				<view class="uni-common-mt" style="background:#FFF; padding:40rpx;">
				    <rich-text :nodes="strings"></rich-text>
				</view>
				<view class="uni-title uni-common-mt">
				    我的：
				</view>
				<view class="uni-common-mt" style="background:#FFF; padding:40rpx;">
				    <rich-text :nodes="strings"></rich-text>
				</view>
		    </view>
		</view>
	</view>
</template>

<script>
	export default {
		onLoad: function () { //option为object类型，会序列化上个页面传递的参数
		      console.log(); 
			  uni.request({
				  url: '',
				  method: 'GET',
				  data: {
				  }
			  })
		},
		data:{
			
		},
		methods :{
		},
	}
</script>

<style>
	.action-row {
		display: flex;
		flex-direction: row;
		justify-content: center;
	}

	.action-row navigator {
		color: #007aff;
		padding: 0 10px;
	}

	.oauth-row {
		display: flex;
		flex-direction: row;
		justify-content: center;
		position: absolute;
		top: 0;
		left: 0;
		width: 100%;
	}

	.oauth-image {
		position: relative;
		width: 50px;
		height: 50px;
		border: 1px solid #dddddd;
		border-radius: 50px;
		margin: 0 20px;
		background-color: #ffffff;
	}

	.oauth-image image {
		width: 30px;
		height: 30px;
		margin: 10px;
	}

	.oauth-image button {
		position: absolute;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		opacity: 0;
	}
	
	.btn-row {
		margin-top: 25px;
		padding: 10px;
	}
</style>
