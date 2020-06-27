<template>
	<view>
		<uni-section title="欢迎您,亲爱的用户!" type="line"></uni-section>
			<view class="example-body">
				<uni-search-bar @confirm="search" @input="input" @cancel="cancel" />
				<view class="search-result">
	
				</view>
			</view>
	</view>
</template>

<script>
	import uniSearchBar from '@/components/uni-search-bar/uni-search-bar.vue'
	import uniSection from '@/components/uni-section/uni-section.vue'
	export default {
	    data() {
	        return {
	            scrollTop: 0,
	            old: {
	                scrollTop: 0
	            }
	        }
	    },
	    methods: {
	        upper: function(e) {
	            console.log(e)
	        },
	        lower: function(e) {
	            console.log(e)
	        },
	        scroll: function(e) {
	            console.log(e)
	            this.old.scrollTop = e.detail.scrollTop
	        },
	        goTop: function(e) {
	            this.scrollTop = this.old.scrollTop
	            this.$nextTick(function() {
	                this.scrollTop = 0
	            });
	            uni.showToast({
	                icon:"none",
	                title:"纵向滚动 scrollTop 值已被修改为 0"
	            })
	        }
	    }
	}
</script>

<style>
	.example-body {
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: center;
		padding: 0;
		font-size: 14px;
		background-color: #ffffff;
	}
	.search-result-text {
		text-align: center;
		font-size: 14px;
	}
</style>
