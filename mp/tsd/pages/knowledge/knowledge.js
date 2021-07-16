// pages/dynamic/dynamic.js
import {userInfo} from '../../utils/userInfo'
const app = getApp()
Page({

    /**
     * 页面的初始数据
     */
    data: {
        imgPath:'/resources/imgs/add_img.png',
        abs:'a',
        content:'b'
    },
    publishKnowledge(){
        var userID = userInfo.getUserInfo().userID;
        if(! userID){
            wx.showToast({
              title: '至“我的”登录',
              "icon": "error"
            })
           
        }else{
            var data = {"user.userID": userID, "abs":this.data.abs, "content":this.data.content}
            console.log(data);

            // 向服务器发送数据
            wx.uploadFile({
              filePath: this.data.imgPath,
              name: 'pic',
              url: app.globalData.serverURL+'/publishKnowledge',
              header:{"contentType": "application/json;charset=utf-8"},
              formData: data,
              success: (res)=>{
                  console.log(res)
                  if(res.data='{"success":true}'){
                    wx.showToast({
                        title: '发布成功',
                        success:()=>{
                            setTimeout(() => {
                                wx.navigateBack({
                                    delta:1
                                })
                            }, 2000);
                        }
                      })
                  }else{
                      wx.showToast({
                        title: '发布失败',
                        icon:"error"
                      })
                  }
              }
            })


        }
       
    },
    selectImg(){
        var that = this;
        wx.chooseImage({
          count: 1,
          success:function(res){
            var img = res.tempFiles[0];
            console.log(img);
                that.setData({ imgPath:img.path});
          }
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
       
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