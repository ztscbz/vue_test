<template>
  <div id="login">
    <div class="login-warp">
      <h1 style="color: #fff;">欢迎登录ZT的博客后台</h1>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" size="medium" class="login-form">

        <el-form-item prop="user" class="item-form">
          <label>用户名</label>
          <el-input v-model="ruleForm.user"></el-input>
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
    mounted() {//挂载完成时
      // this.query();
    },
    data() {
      const validateUser = (rule, value, callback) => {
        console.log(value)
        if (value === '') {
          return callback(new Error('登录账号不能为空'));
        }
        if (this.ruleForm.user !== '') {
          this.$refs.ruleForm.validateField('username');
        }
        callback();
      };
      const validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      const validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          pass: '',
          checkPass: '',
          user: ''
        },
        rules: {
          user: [
            {validator: validateUser, trigger: 'blur'}
          ],
          pass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: validatePass2, trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      query() {
        this.$axios.get('/m5/queryPeople', {}).then(res => {
          console.log(res)
        })
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$router.push('/console')
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
  }
</script>

<style lang="scss" scoped>
  #login{
    height: 100vh;
    background: url("/images/bj.jpg") no-repeat; overflow: hidden;
    background-size:cover;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .login-warp{
    width: 330px;
    margin: auto;
    /*height: 100vh;*/
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
