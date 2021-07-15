class UserInfo{

    saveUserInfo(user) {
        wx.setStorageSync('userInfo', user)
    }

    getUserInfo() {
        return wx.getStorageSync('userInfo');
    }
}

export var  userInfo = new UserInfo();