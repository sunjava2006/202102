// pages/home/home.js
const app = getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        "currID":1,
        "showPublish":false,
        "list":[],
        "currpage":1,
        "size":6,
        "totalPage":0
    },
    openKnowledge(){
        this.setData({"showPublish":false})
        wx.navigateTo({
          url: '/pages/knowledge/knowledge'
        })
    },
    openDynamic(){
        this.setData({"showPublish":false})
        wx.navigateTo({
          url: '/pages/dynamic/dynamic'
        })
    },
    hidePublish:function(){
        this.setData({"showPublish":false});
    },
    toPublish:function(evt){
        this.setData({"showPublish":true});
    },
    clickItem:function(evt){
        console.log(evt.target.id);
        var currID = evt.target.id;
        this.setData({"currID":currID});
    },
    swiperSlide:function(evt){
        var currID = evt.detail.current;
        this.setData({"currID":currID});
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
         console.log("onLoad")
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
        console.log("onReady")
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        console.log('onShow')
        this.listKnowledge(this.data.currpage, this.data.size);
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

    },

    listKnowledge(page, size){
        console.log('------------------listKnowledge--------------')
        wx.request({
          url: app.globalData.serverURL+'/listKnowledge',
          method:"POST",
          data: {"page": page, "size": size},
          success:(res) =>{
              console.log(res);
              var list = this.data.list;
              for(var i in res.data.list){
                list.push(res.data.list[i]);
              }

              this.setData({
                  currpage:res.data.currPage,
                  list:list,
                  totalPage : res.data.totalPage
              });
          }
        })
    },
    nextPage(){
        console.log("------------nextPage-----------")
        if(this.data.currpage<this.data.totalPage){
            this.listKnowledge(this.data.currpage+1, this.data.size);
        }
    }
})