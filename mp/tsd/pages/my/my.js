// pages/my/my.js
const app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        useUserInfo:false,
        userInfo: app.globalData.useUserInfo
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
            // console.log(app.globalData)
            this.setData({
              userInfo: res.userInfo,
              useUserInfo: true
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
      if(!this.data.useUserInfo){
        console.log("onShow----------------")
            this.getUserProfile();
       }
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