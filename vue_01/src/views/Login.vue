<template>
  <div>
    <h1>登录页面</h1>
  </div>
</template>

<script>
  export default {
    name: "Login",
    mounted () {//挂载完成时
      this.query();
    },
    methods:{
      query() {
        this.$axios.get('/m5/queryPeople',{}).then(res=>{
          console.log(res)
        })
      }
    },
  }
</script>

<style scoped>

</style>
