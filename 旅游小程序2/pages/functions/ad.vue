<template>
	<view>
	  <canvas canvas-id="imgCanvas" style="width: 100%;height: 1000rpx;">
	  	<view class="canvas-text"></view>
	  </canvas>
	  
	  <button style="width: 400rpx;height: auto;background-color: #416dff;" type="primary" class="primary" @tap="shareImage()">一键分享</button>
	</view>
</template>

<script>
	export default {
		onLoad: function (option) { //option为object类型，会序列化上个页面传递的参数
			this.$data.userID = option.userID;
			this.$data.proID = option.proID;
			this.$data.picture = option.picture;
			console.log("proID:" + this.$data.proID);
			this.initData();
		},
		data() {
			return {
				name: "扫码参团报名"
			}
		},
		methods: {
			initData(){
				let that = this;
				uni.showLoading({
					title:"拼命生成中...",
					mask:true,
				});
				var bgPath;
				const ctx = uni.createCanvasContext('imgCanvas');
				uni.downloadFile({
				    url: that.$data.picture,
				    success: (res) => {
				        if (res.statusCode === 200) {
				            console.log(res.tempFilePath);
							ctx.drawImage(res.tempFilePath, 0, 0, 350, 600);
							uni.downloadFile({
							    url: 'http://qr.liantu.com/api.php?text=http://144.34.188.164:8080/ads/getForm?userProID=' + this.$data.userID + ':' + this.$data.proID,
							    success: (res) => {
							        if (res.statusCode === 200)  {
							            console.log(res.tempFilePath);
										that.canvas_text = that.$data.name;
										// ctx.drawImage(bgPath,  0, 0, 400, 500);
									    // ctx.drawImage('https://i.loli.net/2020/06/26/hjl7MLtueabTJgA.jpg', 0, 0, 200,200);
										ctx.drawImage(res.tempFilePath, 200, 300, 100, 100);
										uni.hideLoading();
										ctx.font = '13px Arial';
										ctx.fillStyle = '#000';
										ctx.fillText(that.$data.name, uni.upx2px(508), uni.upx2px(990));
										ctx.draw(true, () => {
											setTimeout(function() {
												uni.canvasToTempFilePath({
													canvasId: 'imgCanvas',
													fileType: 'jpg',
													x: 0,
													y: 0,
													width: that.windowWidth * 0.6,
													height: 100,
													destWidth: that.windowWidth * 0.6,
													height: 100,
													success: function(res) {
														// console.log(res.tempFilePath)
														that.$data.imgPath = res.tempFilePath
														console.log(that.$data.imgPath);
														// 在这里保存图片
													},
													fail: function(error) {
														console.log(error)
													},							
												});
											}, 100);
										});
								    }
							    },
							});
					    }
				    },
				});
				
				// that.drawImage();
			},
			onImgOK(e) {
				this.imagePath = e.detail.path;
				uni.hideLoading();
			},
			imgErr(e){
				uni.hideLoading();
				uni.showModal({
					title:'提示',
					content:"生成海报失败",
					showCancel:false,
				})
				console.log(e);
			},
			saveImage() {  //长按保存
				var _this = this;
				uni.authorize({
					scope:"scope.writePhotosAlbum",
					success() {
						uni.saveImageToPhotosAlbum({
							filePath: _this.imagePath,
							success(){
								uni.showModal({
									title:"保存成功",
									content:"图片已成功保存到相册，快去分享到您的圈子吧",
									showCancel:false
								})
							}
						});
					}
				})
			},
			shareImage() {
				// 分享到微信朋友圈
				var that = this
				//unii-app分享,我在这里是微信分享好友
				uni.share({
						provider: "weixin",
						scene: "WXSceneSession",
						type: 2,
						imageUrl: that.$data.imgPath,
						success: function (res) {
							console.log(res);
						},
						fail: function (err) {
							console.log("fail:" + JSON.stringify(err));
						}
				})
			}
		}
	}
</script>

<style>

</style>
