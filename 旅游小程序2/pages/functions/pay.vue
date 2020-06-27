<!--未支付账单-->
<template>
	<view>
		<text class="example-info"> 我的购物车</text>
		<uni-section title="未付款" type="line"></uni-section>
		<view class="example-body">
			<uni-goods-nav fill="true" :options="options1" :button-group="buttonGroup1" @click="onClick" @buttonClick="buttonClick"/>
		</view>
		<view class="goods-carts">
			<uni-goods-nav :options="options1" :fill="true" :button-group="buttonGroup1" @click="onClick" @buttonClick="buttonClick" />
		</view>

		<uni-section title="已付款" type="line"></uni-section>
		<view class="example-body">
			<uni-goods-nav :fill="true" :options="options2" :button-group="buttonGroup2" @click="onClick" @buttonClick="buttonClick" />
		</view>
		<view class="goods-carts">
			<uni-goods-nav :options="options" :fill="true" :button-group="buttonGroup2" @click="onClick" @buttonClick="buttonClick" />
		</view>

	</view>
</template>

<script>
	export default {
		components: {},
		data() {
			return {
				options1: [{
					icon: 'headphones',
					text: '客服'
				}, {
					icon: 'shop',
					text: '店铺',
					info: 2,
					infoBackgroundColor: '#007aff',
					infoColor: "#f5f5f5"
				},
				],
				buttonGroup1: [{
						text: '删除',
						backgroundColor: '#ffa200',
						color: '#fff'
					},
					{
						text: '支付',
						backgroundColor: '#ff0000',
						color: '#fff'
					}
				],
				options2: [{
					icon: 'headphones',
					text: '客服'
				}, {
					icon: 'shop',
					text: '店铺',
					info: 2,
					infoBackgroundColor: '#007aff',
					infoColor: "#f5f5f5"
				}
				],
				buttonGroup2: [{
						text: '联系',
						backgroundColor: '#ffa200',
						color: '#fff'
					},
					{
						text: '支付',
						backgroundColor: '#ff0000',
						color: '#fff'
					}
				]
			}
		},
		onLoad() {},
		methods: {
			onClick(e) {
				uni.showToast({
					title: `点击${e.content.text}`,
					icon: 'none'
				})
			},
			buttonClick(e) {
				console.log(e)
				this.options[2].info--
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
		font-size: 14px;
		line-height: inherit;
	}

	.example {
		padding: 0 15px 15px;
	}

	.example-info {
		padding: 15px;
		color: #3b4144;
		background: #ffffff;
	}

	.example-body {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: center;
		padding: 0;
		font-size: 14px;
		background-color: #ffffff;
		overflow: hidden;
	}

	/* #endif */
	.example {
		padding: 0 15px;
	}

	.example-info {
		/* #ifndef APP-NVUE */
		display: block;
		/* #endif */
		padding: 15px;
		color: #3b4144;
		background-color: #ffffff;
		font-size: 14px;
		line-height: 20px;
	}

	.example-info-text {
		font-size: 14px;
		line-height: 20px;
		color: #3b4144;
	}


	.example-body {
		flex-direction: column;
		padding: 15px;
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
		padding: 0;
		/* #ifndef APP-NVUE */
		display: block;
		/* #endif */
	}

	.goods-carts {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: column;
		position: fixed;
		left: 0;
		right: 0;
		bottom: 0;
	}
</style>