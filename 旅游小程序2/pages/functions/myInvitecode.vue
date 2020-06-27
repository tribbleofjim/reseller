<!--我的邀请码-->
<template>
	<view>
		<view class="uni-title uni-common-pl">我的邀请码</view>
			<view class="uni-list">
				<view class="uni-list-cell">
					<view class="uni-list-cell-left">
						邀请码：
					</view>
				<view class="uni-list-cell-db">
					<text selectable="true"></text>
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
	}
</script>

<style>
</style>
