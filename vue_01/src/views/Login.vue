<template>
 <div id="login">
   <div class="login-warp">
     <h1 style="color: #fff;">欢迎登录ZT的博客后台</h1>
     <ul class="menu-tab">
       <li v-for="item in menuTab" :key="item.id" :class="{'current':item.current }" @click="toMenu(item)">{{item.txt}}</li>
     </ul>
     <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" size="medium" class="login-form">

       <el-form-item prop="age" class="item-form">
         <label>用户名</label>
         <el-input v-model.number="ruleForm.name"></el-input>
       </el-form-item>

       <el-form-item  prop="pass">
         <label>密码</label>
         <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
       </el-form-item>

       <el-form-item prop="checkPass">
         <label>确认密码</label>
         <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
       </el-form-item>

       <el-form-item>
         <el-button type="primary" @click="submitForm('ruleForm')" class="block">提交</el-button>
       </el-form-item>

     </el-form>
   </div>
 </div>
</template>

<script>
  export default {
    name: "login",
    data(){
      return{
        ruleForm: {
          pass: '',
          checkPass: '',
          name: ''
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur' }
          ],
          age: [
            { validator: checkAge, trigger: 'blur' }
          ]
        },
        menuTab:[
          {txt:'登录',current:true},
          {txt:'注册',current:false}
        ],
      };
      var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('年龄不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (value < 18) {
              callback(new Error('必须年满18岁'));
            } else {
              callback();
            }
          }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      },
    //挂载完成后自动执行
    mounted () {

    },
    methods:{
      toMenu(data){
        this.menuTab.forEach(e =>{
          e.current = false
        })
        data.current = !data.current
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
    }
  }
</script>

<style lang="scss" scoped>
  #login{
    height: 100vh;
    background: url("/images/bj.jpg") no-repeat; overflow: hidden;
    background-size:cover;
    background-color: #2c3e50;
  }
  .login-warp{
    width: 330px;
    margin: auto;
    height: 100vh;
  }
  .menu-tab{
    text-align: center;
    li {
      display: inline-block;
      width: 88px;
      height: 36px;
      font-size: 14px;
      color: #fff;
      line-height: 36px;
      border-radius: 2px;
      cursor: pointer;
    }
    .current{
      background-color: rgba(0,0,0,.1);
    }
  }
  .login-form{
    margin-top: 29px;
    label{
      display: block;
      margin-bottom: 3px;
      font-size: 14px;
      color: #fff;
      text-align: left;
    }
    .item-form{
      margin-bottom: 13px;
    }
    .block{
      width: 100%;
      display: block;
    }
  }
</style>
