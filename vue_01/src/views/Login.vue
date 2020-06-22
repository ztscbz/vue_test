<template>
  <div id="div">
    <div class="form">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" size="mini">
        <el-form-item label="用户名" prop="checkUsername">
          <el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off" placeholder="确认密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Login",
        mounted() {//挂载完成时
            // this.query();
        },
        data() {
            const validateUser = (rule, value, callback) => {
                if (value ==='') {
                    return callback(new Error('登录账号不能为空'));
                }
                if (this.ruleForm.username !== '') {
                    this.$refs.ruleForm.validateField('validateUser');
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
                    username: ''
                },
                rules: {
                    pass: [
                        {validator: validatePass, trigger: 'blur'}
                    ],
                    checkPass: [
                        {validator: validatePass2, trigger: 'blur'}
                    ],
                    checkUsername: [
                        {validator: validateUser, trigger: 'blur'}
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

<style scoped>
  #div {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: url("./images/td061902.jpg") no-repeat;
    background-size: cover;
  }
  .form {
    margin: 0 auto;
    width: 400px;
    display:flex;
  }
</style>
