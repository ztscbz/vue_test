<template>
  <div id="div1">
    <mavon-editor ref=md :ishljs="true" v-model="value" @change="changeData()"/>
  </div>
</template>

<script>
    export default {
        name: "Index",
        data(){
            return {
                value: '',
                defaultData: "preview",
            }
        },
        methods:{
            changeData(){
                console.log(this.$refs.md.d_render)
                //console.log(this.value)
            }
        }
    }
</script>

<style scoped lang="scss">

  ::v-deep .v-note-wrapper .v-note-panel .v-note-edit.divarea-wrapper.transition {
    height: 100vh;
  }

</style>
