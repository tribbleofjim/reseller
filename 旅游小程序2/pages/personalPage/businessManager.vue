<template>
	<view>
		<text class="example-info">欢迎您，亲爱的业务员!</text>
		<view v-for="(item, index) in list" :key="index">
			<uni-section :title="item.name" type="line"></uni-section>
			<uni-collapse ref="add" class="warp" @change="change">
				<uni-collapse-item v-for="(sub, key) in item.data" :key="key" :open="sub.open" :show-animation="sub.showAnimation" :disabled="sub.disabled" :title="sub.subName">
					<template v-if="!sub.type">
						<text @click="Pnavigate(sub.url)" class="content">{{ sub.content }}</text>
					</template>
					<template v-else>
						<uni-list>
							<uni-list-item v-for="(list, listIndex) in sub.subList" :key="listIndex" :title="list.title" :note="list.note" :thumb="list.thumb" :show-extra-icon="list.showExtraIcon" :extra-icon="list.extraIcon" :show-switch="list.showSwitch" @switchChange="change" />
						</uni-list>
					</template>
				</uni-collapse-item>
			</uni-collapse>
		</view>
		<uni-section title="功能" type="line"></uni-section>
		<uni-collapse :accordion="true">
			<uni-collapse-item v-for="item in accordion" :key="item.id" :title="item.title" :show-animation="item.animation">
				<text @click="Mnavigate(item.url)" class="content">{{ item.content }}</text>
			</uni-collapse-item>
		</uni-collapse>
		<button @click="logout()">退出登录</button>
	</view>
</template>

<script>
	var ph
	var pw
	import uniCollapse from '@/components/uni-collapse/uni-collapse.vue'
	import uniCollapseItem from '@/components/uni-collapse-item/uni-collapse-item.vue'
	import uniList from '@/components/uni-list/uni-list.vue'
	import uniListItem from '@/components/uni-list-item/uni-list-item.vue'
	import uniSection from '@/components/uni-section/uni-section.vue'

	export default {
		onLoad: function (event) { //option为object类型，会序列化上个页面传递的参数
		      console.log(event);
		      ph = event.phonenumber;
		      pw = event.password;
		      console.log(ph);
		      console.log(pw)
		},
		components: {
			uniSection,
			uniCollapse,
			uniCollapseItem,
			uniList,
			uniListItem
		},
		data() {
			const listData = [{
					name: '个人信息',
					data: [{
							type: false,
							subName: '编辑信息',
							content: '可编辑个人信息',
							url: '/pages/functions/editPInfo'
						},
						{
							type: false,
							subName: '查看信息',
							content: '可查看个人信息',
							url: '/pages/functions/checkInfo'
						},
					]
				}
			]
			return {
				list: listData,
				accordion: [{
						id: 0,
						title: '查看产品',
						content: '查看所代理的产品',
						animation: true,
						url: '/pages/functions/myProduct'
					},
					{
						id: 1,
						title: '我的业绩',
						content: '查看自己的销售情况',
						animation: true,
						url: '/pages/functions/myAchievement'
					},
					{
						id: 2,
						title: '我的分销商',
						content: '查看我名下的分销商',
						animation: true,
						url: '/pages/functions/myD'
					},
					{
						id: 3,
						title: '我的邀请码',
						content: '通过此邀请码可使他人成为分销商',
						animation: true,
						url: '/pages/functions/myInvitecode'
					},					
					{
						id: 4,
						title: '我的回馈',
						content: '查看分销商的回馈金额',
						animation: true,
						url: '/pages/functions/myPayback'
					},
					{
						id: 5,
						title: '角色更改',
						content: '更改我的角色',
						animation: true,
						url: '/pages/functions/changeRole'
					},
				],
				extraIcon: {
					color: '#4cd964',
					size: '26',
					type: 'image'
				},
				id: 2
			}
		},
		methods: {
			logout(){
				uni.redirectTo({
					url:'/pages/login/login'					
				})
			},
			change(e) {},
			Pnavigate(url){
				uni.navigateTo({
					url: url
				})
			},
			Mnavigate(url){
				uni.navigateTo({
					url: url
				})
			}
		}
	}
</script>

<style>
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
		flex-direction: column;
		flex: 1;
	}

	.content {
		padding: 15px;
		font-size: 14px;
		line-height: 20px;
		background-color: #f9f9f9;
		color: #666;
	}

	.button {
		font-size: 26rpx;
		line-height: 90rpx;
	}
</style>