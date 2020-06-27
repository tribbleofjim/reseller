<template>
	<view class="content">
		<view class="avatarWrapper">
			<view class="avatar">
				<image class=img src="../../static/img/logo.png" mode="width"></image>
			</view>
		</view>
		<view class="form">
			<view class="inputWrapper">
				<m-input class="input" type="text" clearable focus v-model="phonenumber" placeholder="请输入手机号"></m-input>
			</view>
			<view class="inputWrapper">
				<m-input type="password" displayable v-model="password" placeholder="请输入密码"></m-input>
			</view>
			<view class="loginBtn">
		        <button type="btnValue" class="btnValue" @tap="bindLogin">登录</button>
			</view>
		<view class="forgotBtn">
			<navigator url="../login/register">注册账号</navigator>
			<text>|</text>
			<navigator url="../login/password">忘记密码</navigator>
		</view>
		</view>
	</view>
</template>

<script>
	import service from '../../service.js';
		import {
			mapState,
			mapMutations
		} from 'vuex'
		import mInput from '../../components/m-input.vue'
		export default {
			components: {
				mInput
			},
			data() {
				return {
					List: [],
					hasProvider: false,
					phonenumber: '',
					password: '',
					positionTop: 0,
					isDevtools: false,
				}
			},
			computed: mapState(['forcedLogin']),
			methods: {
				bindLogin() {
					if (this.phonenumber.length <= 0) {
						uni.showToast({
							icon: 'none',
							title: '请输入用户名'
						});
						return;
					}
					if (this.password.length <= 0) {
						uni.showToast({
							icon: 'none',
							title: '请输入密码'
						});
						return;
					}
					this.$data.ph = this.phonenumber;
					this.$data.pw = this.password;
					// const data = {
					// 	ph : this.phonenumber,
					// 	pw : this.password
					// };
					console.log(this.$data.ph);
					console.log(this.$data.pw);
				    var request = 'http://144.34.188.164:8080/user/webLogin';
					uni.request({
						url: request,
						method: 'GET',
						data: {
							phonenumber : this.$data.ph,
							password : this.$data.pw
						},
						success: (res) => {
							var that = this;
							let resD = JSON.stringify(res.data)
							console.log(resD);
							const resd = JSON.parse(resD);
							console.log(resd.code);
							if(resd.msg == 'class_5_success'){
								var toPage = '../personalPage/touristPage?phonenumber='+this.$data.ph+'&password='+this.$data.pw;
								console.log(toPage),
								uni.showToast({
									icon: 'none',
									title: '欢迎您，亲爱的游客！',								
								});
								uni.redirectTo({
									url:toPage,
								});

							}
							else if(resd.msg == 'class_4_success'){
								var toPage = '../personalPage/BMofD?phonenumber='+this.$data.ph+'&password='+this.$data.pw;
								console.log(toPage),
								uni.showToast({
									icon: 'none',
									title: '欢迎您，亲爱的二级分销商！',								
								});
								uni.redirectTo({
									url: toPage,
								});
							
							}
							else if(resd.msg == 'class_3_success'){
								var toPage = '../personalPage/distributor?phonenumber='+this.$data.ph+'&password='+this.$data.pw;
								console.log(toPage),
								uni.showToast({
									icon: 'none',
									title: '欢迎您，亲爱的分销商！',								
								});
								uni.redirectTo({
									url: toPage,
								});
							
							}
							else if(resd.msg == 'class_2_success'){
								var toPage = '../personalPage/businessManager?phonenumber='+this.$data.ph+'&password='+this.$data.pw;
								uni.showToast({
									icon: 'none',
									title: '欢迎您，亲爱的业务员！',								
								});
								uni.redirectTo({
									url: toPage,
								});
							
							}
							else{
								uni.showToast({
									icon: 'none',
									title: '用户名或密码错误'
								});
								return;
							}
						},fail: () => {
							uni.showToast({
								icon: 'none',
								title: '网络异常,请稍后重试'
							});
						}
					});
				}
			}
		}
</script>

<style>
	.content {
		background: #55aaff;
		width: 100vw;
		height: 100vh;
	}
    .avatarWrapper{
		height: 30vh;
		width: 100vw;
		display: flex;
		justify-content: center;
		align-items: flex-end;
	}
	.avatar{
		width: 200upx;
		height: 200upx;
		overflow:hidden ;
	}
	.avatar .img{
		width: 100%;
		height: 200upx;
	}
	.form{
		padding:0 100upx;
		margin-top: 80px;
	}
	.inputWrapper{
		width: 100%;
		height: 80upx;
		background: white;
		border-radius: 20px;
		box-sizing: border-box;
		padding: 0 20px;
		margin-top: 25px;
	}
	.inputWrapper .input{
		width: 100%;
		height: 100%;
		text-align: center;
		font-size: 15px;
	}
	
	.loginBtn .btnValue{
		width: 100%;
		height:80upx;
		background: #0055ff;
		border-radius: 50upx;
		margin-top: 50px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.forgotBtn{
		text-align: center;
		color: #EAF6F9;
		font-size: 15px;
		margin-top: 20px;
		padding: 0 10px;
		display: flex;
		flex-direction: row;
		justify-content: center;
	}
	
</style>
