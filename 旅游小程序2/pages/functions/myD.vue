<template>
	<view>
		<view class="uni-padding-wrap uni-common-mt">
			<uni-segmented-control :current="current" :values="items" :style-type="styleType" :active-color="activeColor" @clickItem="onClickItem" />
		</view>
		<view class="content">
			<view v-if="current === 0">
				<text class="content-text">我所属的公司业务员：{{ superior }}</text>
			</view>
			<view v-if="current === 1" style="padding-top: 200rpx;">
				<text class="content-text">我下级的分销商业务员：</text>
				<uni-grid :column="1" :highlight="true">
					<uni-grid-item v-for="(item, index) in operators" :key="index" >
						<view class="grid-item-box">
							<text class="text">姓名：{{ item.loginname }}</text>
						</view>
						<view>
							<text class="text">电话号码：{{ item.phonenumber }}</text>
						</view>
						<view>
							<text class="text">qq号：{{ item.qqnumber }}</text>
						</view>
					</uni-grid-item>
				</uni-grid>
			</view>
		</view>
	</view>
</template>

<script>
	var ph
	var pw
	import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue'
	import uniSection from '@/components/uni-section/uni-section.vue'
	export default {
		onLoad: function (event) { //option为object类型，会序列化上个页面传递的参数
			console.log(event.phonenumber);
			ph = event.phonenumber;
			pw = event.password;
			console.log(ph);
			console.log(pw);
			this.getOperators();
			this.getSuperior();
		},
		components: {
			uniSection,
			uniSegmentedControl
		},
		data() {
			return {
				operators: null,
				superior: null,
				items: ['我的上级', '我的下级'],
				styles: [{
						value: 'button',
						text: '按钮',
						checked: true
					},
					{
						value: 'text',
						text: '文字'
					}
				],
				colors: ['#007aff', '#4cd964', '#dd524d'],
				current: 0,
				colorIndex: 0,
				activeColor: '#007aff',
				styleType: 'button'
			}
		},
		methods: {
			onClickItem(e) {
				if (this.current !== e.currentIndex) {
					this.current = e.currentIndex
				}
			},
			getSuperior() {
				var that = this;
				uni.request({
					url:'http://144.34.188.164:8080/reseller/superior',
					method:'GET',
					data:{
						phoneNumber: ph
					},
					success: (res) => {
						console.log(res.data.data);
						this.$data.superior = res.data.data;
					}
				})
			},
			getOperators() {
				var that = this;
				uni.request({
					url:'http://144.34.188.164:8080/reseller/operators',
					method:'GET',
					data:{
						phoneNumber: ph
					},
					success: (res) => {
						console.log(res.data.data);
						that.$data.operators = res.data.data;
					}
				})
			}
		}
	}
</script>

<style>
	/* 头条小程序组件内不能引入字体 */
	/* #ifdef MP-TOUTIAO */
	@font-face {
		font-family: uniicons;
		font-weight: normal;
		font-style: normal;
		src: url('~@/static/uni.ttf') format('truetype');
	}

	/* #endif */

	/* #ifndef APP-NVUE */
	page {
		display: flex;
		flex-direction: column;
		box-sizing: border-box;
		background-color: #efeff4;
		min-height: 100%;
		height: auto;
	}

	view {
		font-size: 28rpx;
		line-height: inherit;
	}

	.example {
		padding: 0 30rpx 30rpx;
	}

	.example-info {
		padding: 30rpx;
		color: #3b4144;
		background: #ffffff;
	}

	.example-body {
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: center;
		padding: 0;
		font-size: 14rpx;
		background-color: #ffffff;
	}

	/* #endif */
	.example {
		padding: 0 30rpx;
	}

	.example-info {
		/* #ifndef APP-NVUE */
		display: block;
		/* #endif */
		padding: 30rpx;
		color: #3b4144;
		background-color: #ffffff;
		font-size: 30rpx;
	}

	.example-info-text {
		font-size: 28rpx;
		line-height: 36rpx;
	}


	.example-body {
		flex-direction: column;
		padding: 30rpx;
		background-color: #ffffff;
	}

	.word-btn-white {
		font-size: 18px;
		color: #FFFFFF;
	}

	.word-btn {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		align-items: center;
		justify-content: center;
		border-radius: 6px;
		height: 48px;
		margin: 15px;
		background-color: #007AFF;
	}

	.word-btn--hover {
		background-color: #4ca2ff;
	}



	.example-body {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		padding: 0;
	}

	.uni-common-mt {
		margin-top: 30px;
	}

	.uni-padding-wrap {
		width: 750rpx;
		padding: 0px 30px;
	}

	.content {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		justify-content: center;
		align-items: center;
		height: 150px;
		text-align: center;
	}

	.content-text {
		font-size: 18px;
		color: #333;
	}

	.color-tag {
		width: 25px;
		height: 25px;
	}

	.uni-list {
		flex: 1;
	}

	.uni-list-item {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex: 1;
		flex-direction: row;
		background-color: #FFFFFF;
	}


	.uni-list-item__container {
		padding: 12px 15px;
		width: 100%;
		flex: 1;
		position: relative;
		/* #ifndef APP-NVUE */
		display: flex;
		box-sizing: border-box;
		/* #endif */
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		border-bottom-style: solid;
		border-bottom-width: 1px;
		border-bottom-color: #e5e5e5;
	}

	.uni-list-item__content-title {
		font-size: 16px;
	}
</style>