import {userInfo} from '../../utils/userInfo'
const app = getApp();

Page({

    /**
     * 页面的初始数据
     */
    data: {
        serverURL:app.globalData.serverURL,
        gradList:['好评','中评','差评'],
        grad:'好评',
        recomment:'recomment',
        knowledgeID:9,
        show:false,
        currPage:1,
        size:5,
        knowledge:null,
        recommentList:[],
        totalPage:1
    },
    getKnowledge(id){
        wx.request({
          url: app.globalData.serverURL+'//getKnowledge/'+id,
          success:(res)=> {
              console.log(res);
              this.setData({knowledge:res.data})
          }
        })
    },
    listRecomment(page, size){
        wx.request({
          url: app.globalData.serverURL+ '/listRecomment',
          method:'GET',
          data:{page:page,size:size,knowledgeID:this.data.knowledgeID},
          header:{"Content-Type":"application/x-www-form-urlencoded"},
          success: (res)=>{
              console.log(res);
              var list = this.data.recommentList;
              for(var i in res.data.list){
                  list.push(res.data.list[i]);
              }
              this.setData({
                  recommentList:list,
                  currPage:res.data.currPage,
                  totalPage: res.data.totalPage
              });
          }
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        
        console.log(options)
        var id = options.knowledgeID;
        this.setData({knowledgeID:id})
        this.getKnowledge(id);
        this.listRecomment(this.data.currPage, this.data.size);
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

    },
    editRecomment(){
        this.setData({show:true})
    },
    choseGrad(evt){
        console.log('-------------------------------')
        console.log(evt)
        var grad = evt.detail.value;
        this.setData({grad:grad});
    },
    publishRecomment(){
        this.setData({show:false})
        wx.request({
          url: app.globalData.serverURL + '/publishRecomment',
          data: {knowledgeID:this.data.knowledgeID, 'user.userID': userInfo.getUserInfo().userID, content:this.data.recomment, grad:this.data.grad},
          success:(res)=> {
              var msg = res.data.publish;
              if('ok'==msg){
                  this.data.recommentList=[];
                  this.listRecomment(1, this.data.size);
                  wx.showToast({
                    title: '评论成功'
                  })
              }else{
                wx.showToast({
                    title: '评论失败',
                    icon:"error"
                  })
              }
          }
        })
    },
    nextPage(){
        if(this.data.currPage<this.data.totalPage){
            this.listRecomment(this.data.currPage+1, this.data.size);
        }
    }

})