<template>
	<view class="content">
		<view class="input-group">
			<view class="input-row border">
				<text class="title">用户名：</text>
				<m-input type="text" focus clearable v-model="loginName" placeholder="请输入用户名"></m-input>
			</view>
			<view class="input-row ">
				<text class="title">手机号：</text>
				<m-input type="text" focus clearable v-model="phonenumber" placeholder="请输入手机号"></m-input>
			</view>
			<view class="input-row border">
				<text class="title">密码：</text>
				<m-input type="password" displayable v-model="password" placeholder="请输入密码"></m-input>
			</view>
			<view class="input-row ">
				<text class="title">QQ：</text>
				<m-input type="qqnumber" focus clearable v-model="qqnumber" placeholder="请输入QQ号"></m-input>
			</view>
			<view class="input-row ">
				<text class="title">年龄：</text>
				<m-input type="age" focus clearable v-model="age" placeholder="请输入年龄"></m-input>
			</view>
			<view class="input-row ">
				<text class="title">城市：</text>
				<m-input type="city" focus clearable v-model="city" placeholder="请输入城市"></m-input>
			</view>
		</view>
		<view class="btn-row">
			<button type="primary" class="primary" @tap="register">注册</button>
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
				loginName:'',
				password: '',
				phonenumber: '',
				qqnumber:'',
				age:'',
				city:''
			}
		},
		methods: {
			register() {
				/**
				 * 客户端对账号信息进行一些必要的校验。
				 * 实际开发中，根据业务需要进行处理，这里仅做示例。
				 */
				
				if (this.loginName.length < 5) {
					uni.showToast({
						icon: 'none',
						title: '账号最短为 5 个字符'
					});
					return;
				}
				if (this.phonenumber.length !=11) {
					uni.showToast({
						icon: 'none',
						title: '手机号不正确'
					});
					return;
				}
				if (this.password.length < 6) {
					uni.showToast({
						icon: 'none',
						title: '密码最短为 6 个字符'
					});
					return;
				}			
				const data = {
					loginName:this.loginName,
					password: this.password,
					phonenumber: this.phonenumber,
					qqnumber:this.qqnumber,
					age:this.age,
					city:this.city
				}
				console.log(data.loginName)
				uni.request({
					url: 'http://144.34.188.164:8080/user/webRegister',
					method:'POST',
					header: {
						'content-type': 'application/x-www-form-urlencoded', 
					},
					data:{
						password:data.password,
						confirmPassword:data.password,
						loginName:data.loginName,
						phoneNumber:data.phonenumber,
						qqNumber:data.qqnumber,
						age: data.age,
						city: data.city,
						role:'游客'						
					},
					success: (res) => {
						console.log(res.data);
						uni.navigateTo({
							url:'/pages/login/login'
						})
					}
				})
			}
		}
	}
</script>

<style>

</style>
