package net.sourceforge.simcpux;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.json.JSONObject;


//Ko Ref : https://blog.kimkevin.net/android-dev-wechat-pay/
public class PayActivity extends Activity {

	private IWXAPI api;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay);

		api = WXAPIFactory.createWXAPI(this, "wxb4ba3c02aa476ea1");

		Button appayBtn = (Button) findViewById(R.id.appay_btn);
		appayBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String url = "https://wxpay.wxutil.com/pub_v2/app/app_pay.php";
				Button payBtn = (Button) findViewById(R.id.appay_btn);
				payBtn.setEnabled(false);
				Toast.makeText(PayActivity.this, "주문받으러...", Toast.LENGTH_SHORT).show();
				Util.httpGet(url, new bCb<byte[]>() {
					@Override
					public void onSuccess(byte[] buf) {
						try {
							if (buf != null && buf.length > 0) {
								String content = new String(buf);
								Log.e("get server pay params:", content);
								JSONObject json = new JSONObject(content);
								if (null != json && !json.has("retcode")) {
									PayReq req = new PayReq();
									//req.appId = "wxf8b4f85f3a794e77";  // 测试用appId
									req.appId = json.getString("appid");
									req.partnerId = json.getString("partnerid");
									req.prepayId = json.getString("prepayid");
									req.nonceStr = json.getString("noncestr");
									req.timeStamp = json.getString("timestamp");
									req.packageValue = json.getString("package");
									req.sign = json.getString("sign");
									req.extData = "app data"; // optional
									Toast.makeText(PayActivity.this, "일반 이체 지불", Toast.LENGTH_SHORT).show();
									// 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
									//지불 전에 응용 프로그램이 WeChat에 등록되어 있지 않으면 먼저 IWXMsg.registerApp를 호출하여 응용 프로그램을 WeChat에 등록해야합니다.
									api.sendReq(req);
								} else {
									Log.d("PAY_GET", "반환 오류" + json.getString("retmsg"));
									Toast.makeText(PayActivity.this, "반환 오류" + json.getString("retmsg"), Toast.LENGTH_SHORT).show();
								}
							} else {
								Log.d("PAY_GET", "서버 요청 오류");
								Toast.makeText(PayActivity.this, "서버 요청 오류", Toast.LENGTH_SHORT).show();
							}
						} catch (Exception e) {
							Log.e("PAY_GET", "비정상적인：" + e.getMessage());
							Toast.makeText(PayActivity.this, "비정상적인：" + e.getMessage(), Toast.LENGTH_SHORT).show();
						}
					}
				});
				payBtn.setEnabled(true);
			}
		});
		Button checkPayBtn = (Button) findViewById(R.id.check_pay_btn);
		checkPayBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean isPaySupported = api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
				Toast.makeText(PayActivity.this, String.valueOf(isPaySupported), Toast.LENGTH_SHORT).show();
			}
		});
	}

}
