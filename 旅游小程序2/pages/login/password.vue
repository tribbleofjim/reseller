<template>
	<view class="content">
		<view class="form">
			<view class="inputWrapper">
				<m-input class="input" type="text" clearable focus v-model="phonenumber" placeholder="请输入手机号"></m-input>
			</view>
		</view>

		<view class="btn-row">
			<button type="btn" class="btn" @tap="findPassword">提交</button>
		</view>
	</view>
</template>

<script>
	import service from '../../service.js';
	import mInput from '../../components/m-input.vue';

	export default {
		components: {
			mInput
		},
		data() {
			return {
				phonenumber: ''
			}
		},
		methods: {
			findPassword() {
				/**
				 * 仅做示例
				 */
				if (this.phonenumber.length !=11) {
					uni.showToast({
						icon: 'none',
						title: '手机号不正确'
					});
					return;
				}
				else{
					
					uni.request({
						url:'',
						method:'',
						success: (res) => {
							
						}
					})
				}
				uni.showToast({
					icon: 'none',
					title: '已发送验证码至手机短信，请注意查收。',
					duration: 3000
				});
			}
		}
	}
</script>

<style>
	.inputWrapper{
		width: 100%;
		height: 80upx;
		background: #fffaf3;
		border-radius: 20px;
		box-sizing: border-box;
		padding: 0 20px;
		margin-top: 25px;
	}
	.btn-row .btn{
		width: 100%;
		height:80upx;
		background: #0055ff;
		border-radius: 50upx;
		margin-top: 50px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
</style>
