<template>
	<view class="warp">
		<uni-section title="我的产品" type="line"></uni-section>
		<view class="example-body">
			<uni-grid :column="1" :highlight="true" @change="change">
				<uni-grid-item v-for="(item, index) in list" :key="index" >
					<view class="grid-item-box">
						<text class="text">{{ item.name }}</text>
						<text class="text">产品详情：{{ item.info }}</text>
						<text class="text">产品价格：{{ item.price }}</text>
					</view>
				</uni-grid-item>
			</uni-grid>
			<!-- <swiper class="swiper" :indicator-dots="true">
				<swiper-item>
					<uni-grid :column="3" :highlight="true" @change="change">
						<uni-grid-item v-for="(item, index) in list" :index="index" :key="index">
							<view class="grid-item-box">
								<image :src="item.url" class="image" mode="aspectFill" />
								<text class="text">{{ item.name }}</text>
							</view>
						</uni-grid-item>
					</uni-grid>
				</swiper-item>
				<swiper-item>
					<uni-grid :column="3" :highlight="true" @change="change">
						<uni-grid-item v-for="(item, index) in list" :index="index" :key="index">
							<view class="grid-item-box">
								<image :src="item.url" class="image" mode="aspectFill" />
								<text class="text">{{ item.name }}</text>
							</view>
						</uni-grid-item>
					</uni-grid>
				</swiper-item>
				<swiper-item>
					<uni-grid :column="3" :highlight="true" @change="change">
						<uni-grid-item v-for="(item, index) in list" :index="index" :key="index">
							<view class="grid-item-box">
								<image :src="item.url" class="image" mode="aspectFill" />
								<text class="text">{{ item.name }}</text>
							</view>
						</uni-grid-item>
					</uni-grid>
				</swiper-item>
			</swiper> -->
		</view>
		<!-- <view>
			<button @click="getProducts()">获取我的产品</button>
		</view> -->
	</view>
</template>

<script>
	var ph
	var pw
	import uniSection from '@/components/uni-section/uni-section.vue'
	import uniGrid from '@/components/uni-grid/uni-grid.vue'
	import uniGridItem from '@/components/uni-grid-item/uni-grid-item.vue'
	import uniBadge from '@/components/uni-badge/uni-badge.vue'
	export default {
		onLoad: function (event) { //option为object类型，会序列化上个页面传递的
			  this.$data.ph = event.phonenumber;
			  this.$data.pw = event.password;
			  console.log(this.$data.ph);
			  console.log(this.$data.pw);
			  this.getProducts();
		},
		components: {
			uniSection,
			uniGrid,
			uniGridItem,
			uniBadge
		},
		data() {
			return {
				dynamicList: [],
				list: [{
						name: '产品1',
						badge: '0',
						type: "primary",
						id:'',
						companyId:'',
						cost:'',
						info:'',
						sale:''
					}
				]
			}
		},
		methods: {
			change(e) {
				let {
					index
				} = e.detail
				// this.$data.list[index].id && this.$data.list[index].id++
				// console.log(this.$data.list[index].id);
				var request = '../infomation/showPro?id='+this.$data.list[index].id+'&name='+
				this.$data.list[index].name+'&companyId='+this.$data.list[index].companyID+'&price='+
				this.$data.list[index].price+'&info='+this.$data.list[index].info + '&userID=' + this.$data.ph +
				'&picture=' + this.$data.list[index].picture; 
				uni.navigateTo({
					url:request
				})
			},
			getProducts(){
				var that = this;
				uni.request({
					url:'http://144.34.188.164:8080/comoper/products',
					method:'GET',
					data:{
						phonenumber:ph,
						password:pw
					},
					success: (res) => {
						console.log(res.data.data);
						that.$data.list = res.data.data;
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
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: center;
		padding: 0;
		font-size: 14px;
		background-color: #ffffff;
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


	.image {
		width: 50rpx;
		height: 50rpx;
	}

	.text {
		font-size: 26rpx;
		margin-top: 10rpx;
	}

	.example-body {
		/* #ifndef APP-NVUE */
		display: block;
		/* #endif */
	}

	.grid-dynamic-box {
		margin-bottom: 15px;
	}

	.grid-item-box {
		flex: 1;
		/* position: relative;
 */
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: column;
		align-items: center;
		justify-content: center;
		padding: 15px 0;
	}

	.grid-dot {
		position: absolute;
		top: 5px;
		right: 15px;
	}

	.swiper {
		height: 420px;
	}
</style>