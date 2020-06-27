<template>
	<!-- <uni-indexed-list :options="list" :show-select="true" @click="bindClick" /> -->
	<uni-grid :column="1" :highlight="true" @change="change">
		<uni-grid-item v-for="(item, index) in list" :key="index">
			<view class="grid-item-box">
				<view>
					<text class="text">产品名称：{{ item.proName }}</text>
				</view>
				<view>
					<text class="text">产品金额：{{ item.price }}</text>
				</view>
				<view>
					<text class="text">点击量：{{ item.sales }}</text>
				</view>
			</view>
		</uni-grid-item>
	</uni-grid>
</template>

<script>
	import airport from '@/static/achievement.js'
	import uniIndexedList from '@/components/uni-indexed-list/uni-indexed-list.vue'
	export default {
		onLoad: function (event) { //option为object类型，会序列化上个页面传递的参数
			this.$data.ph = event.phonenumber;
			this.getOrders();
		},
		components: {
			// uniIndexedList
		},
		data() {
			return {
				// list: airport.list
				list: null,
				ph: null
			}
		},
		methods: {
			bindClick(e) {
				console.log('点击item，返回数据' + JSON.stringify(e));
				uni.navigateTo({
					url:'../infomation/achievement'
				})
			},
			getOrders() {
				var that = this;
				uni.request({
					url:'http://144.34.188.164:8080/reseller/superior',
					method:'GET',
					data:{
						phoneNumber: that.$data.ph
					},
					success: (res) => {
						console.log(res.data.data);
						this.$data.list = res.data.data;
					}
				})
			}
		}
	}
</script>

<style></style>