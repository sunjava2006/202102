// pages/my/my.js
const app = getApp();
import {userInfo} from '../../utils/userInfo';
Page({
    /**
     * 页面的初始数据
     */
    data: {
        useUserInfo:false,
        userInfo: app.globalData.useUserInfo
    },
    getPhoneNumber (e) {
      // console.log(e.detail.errMsg)
      // console.log(e.detail.iv)
      // console.log(e.detail.encryptedData)
      console.log(app.globalData.phoneNumber)
    },
    getUserProfile(e) {
      console.log("%%%%%%%%%%%%%%%%%%%%%%%%%")
        // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
        wx.getUserProfile({
          desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
          complete: (res) => {
            console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
            console.log(res)
            // console.log(app.globalData)
            app.globalData.userInfo = res.userInfo;
            console.log(app.globalData)
            this.setData({
              userInfo: res.userInfo,
              useUserInfo: true
            })

            // 向服务器发送用户的信息
            wx.request({
              url: app.globalData.serverURL+'/login',
              data:{"phoneNumber":app.globalData.phoneNumber, "userName": this.data.userInfo.nickName, "avatarUrl": this.data.userInfo.avatarUrl},
              method:"POST",
              success:function(res){
                console.log(res);
                // 将用户信息存储到小程序内部。以供以后向服务端发送数据时，带上用户ID.
                userInfo.saveUserInfo(res.data.user);
              }

            })



          }
        })

    
      },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
         console.log("onLoad----------------")
        
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
     
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
      // if(!this.data.useUserInfo){
      //   console.log("onShow----------------")
      //       this.getUserProfile();
      //  }
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})