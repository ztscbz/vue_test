import axios from 'axios'

// Set config defaults when creating the instance
const $axios = axios.create({
  timeout: 60000,
  baseURL: '/api'
});

// 添加请求拦截器
$axios.interceptors.request.use(function (config) {
  // 在发送请求之前做些什么
  return config;
}, function (error) {
  // 对请求错误做些什么
  return Promise.reject(error);
});

// 添加响应拦截器
$axios.interceptors.response.use(function (response) {
  // 对响应数据做点什么
  return response;
}, function (error) {
  // 对响应错误做点什么
  return Promise.reject(error);
});


export default {

  get(url, params) {
    return $axios({
      url,
      method: 'GET',
      params
    })
  },

  //封装post请求
  post(url, data) {
    return $axios({
      url,
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=UTF-8'
      },
      data
    })
  }
};
