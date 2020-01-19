# PasswordViewDemo
android仿支付宝支付密码和自定义键盘
效果图：![alt text](https://raw.githubusercontent.com/kentlee2/PasswordViewDemo/master/20160408182700801.png)


使用方法：
   passView = new PassView(this);  
   passView.setOnFinishInput(this);  //输入完成最后一个数字监听
  @Override  
    public void inputFinish() {  
        Toast.makeText(getApplicationContext(), passView.getStrPassword(), Toast.LENGTH_SHORT).show();  
          
    }  
    
    
    核心代码（PassView.java）：
    	  //设置监听方法，在第6位输入完成后触发
    public void setOnFinishInput(final OnPasswordInputFinish pass) {
        tvList[5].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 1) {
                    strPassword = "";     //每次触发都要先将strPassword置空，再重新获取，避免由于输入删除再输入造成混乱
                    for (int i = 0; i < 6; i++) {
                        strPassword += tvList[i].getText().toString().trim();
                    }
                    pass.inputFinish();    //接口中要实现的方法，完成密码输入完成后的响应逻辑
                }
            }
        });
    }
