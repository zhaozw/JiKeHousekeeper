package com.jike.shanglv;

import org.json.JSONObject;
import org.json.JSONTokener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jike.shanglv.Common.CommonFunc;
import com.jike.shanglv.Enums.PackageKeys;
import com.jike.shanglv.Enums.Platform;
import com.jike.shanglv.Enums.SPkeys;
import com.jike.shanglv.NetAndJson.HttpUtils;
import com.jike.shanglv.NetAndJson.JSONHelper;
import com.jike.shanglv.NetAndJson.UserInfo;
import com.jike.shanglv.Update.UpdateManager;



public class ActivityBMenu extends Activity {

	public static ActivityBMenu instance = null;
	private LinearLayout ll05, gnjp_ll, gjjp_ll, jdyd_ll, hcp_ll, jdmp_ll,
			hfcz_ll, hbdt_ll, wpt_ll, sxy_ll, fxgl_ll, khgl_ll, zhgl_ll,
			ddgl_ll, wd_ll, fuzhu_ll1;
	private ImageButton imgBtn_gnjp, imgBtn_gjjp, imgBtn_jdyd, imgBtn_hcp,
			imgBtn_jdmp, imgBtn_hfcz, imgBtn_hbdt, imgBtn_wpt, imgBtn_sxy,
			imgBtn_fxgl, imgBtn_khgl, imgBtn_zhgl, imgBtn_ddgl, imgBtn_wd;
	private Context context;
	private SharedPreferences sp;
	private String loginReturnJson = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_b_menu);
			context = this;
			sp = getSharedPreferences(SPkeys.SPNAME.getString(), 0);
			((MyApplication) getApplication()).addActivity(this);

			MyApp mApp = new MyApp(getApplicationContext());
			((ImageView) findViewById(R.id.menu_logo))
					.setBackgroundResource((Integer) mApp.getHm().get(
							PackageKeys.MENU_LOGO_DRAWABLE.getString()));
			if (!HttpUtils.showNetCannotUse(context)) {
				if (!((MyApplication) getApplication()).getHasCheckedUpdate()) {
					MyApp ma = new MyApp(context);
					UpdateManager manager = new UpdateManager(context, ma
							.getHm().get(PackageKeys.UPDATE_NOTE.getString())
							.toString());
					manager.checkForUpdates(false);
					((MyApplication) getApplication())
							.setHasCheckedUpdate(true);
				}
			}
			imgBtn_gnjp = (ImageButton) findViewById(R.id.imgBtn_gnjp);
			imgBtn_gjjp = (ImageButton) findViewById(R.id.imgBtn_gjjp);
			imgBtn_jdyd = (ImageButton) findViewById(R.id.imgBtn_jdyd);
			imgBtn_hcp = (ImageButton) findViewById(R.id.imgBtn_hcp);
			imgBtn_jdmp = (ImageButton) findViewById(R.id.imgBtn_jdmp);
			imgBtn_hfcz = (ImageButton) findViewById(R.id.imgBtn_hfcz);
			imgBtn_hbdt = (ImageButton) findViewById(R.id.imgBtn_hbdt);
			imgBtn_wpt = (ImageButton) findViewById(R.id.imgBtn_wpt);
			imgBtn_sxy = (ImageButton) findViewById(R.id.imgBtn_sxy);
			imgBtn_fxgl = (ImageButton) findViewById(R.id.imgBtn_fxgl);
			imgBtn_khgl = (ImageButton) findViewById(R.id.imgBtn_khgl);
			imgBtn_zhgl = (ImageButton) findViewById(R.id.imgBtn_zhgl);
			imgBtn_ddgl = (ImageButton) findViewById(R.id.imgBtn_ddgl);
			imgBtn_wd = (ImageButton) findViewById(R.id.imgBtn_wd);
			imgBtn_gnjp.setOnClickListener(btnClickListner);
			imgBtn_gjjp.setOnClickListener(btnClickListner);
			imgBtn_jdyd.setOnClickListener(btnClickListner);
			imgBtn_hcp.setOnClickListener(btnClickListner);
			imgBtn_jdmp.setOnClickListener(btnClickListner);
			imgBtn_hfcz.setOnClickListener(btnClickListner);
			imgBtn_hbdt.setOnClickListener(btnClickListner);
			imgBtn_wpt.setOnClickListener(btnClickListner);
			imgBtn_sxy.setOnClickListener(btnClickListner);
			imgBtn_fxgl.setOnClickListener(btnClickListner);
			imgBtn_khgl.setOnClickListener(btnClickListner);
			imgBtn_zhgl.setOnClickListener(btnClickListner);
			imgBtn_ddgl.setOnClickListener(btnClickListner);
			imgBtn_wd.setOnClickListener(btnClickListner);
			gnjp_ll = (LinearLayout) findViewById(R.id.gnjp_ll);
			gjjp_ll = (LinearLayout) findViewById(R.id.gjjp_ll);
			jdyd_ll = (LinearLayout) findViewById(R.id.jdyd_ll);
			hcp_ll = (LinearLayout) findViewById(R.id.hcp_ll);
			jdmp_ll = (LinearLayout) findViewById(R.id.jdmp_ll);
			hfcz_ll = (LinearLayout) findViewById(R.id.hfcz_ll);
			hbdt_ll = (LinearLayout) findViewById(R.id.hbdt_ll);
			wpt_ll = (LinearLayout) findViewById(R.id.wpt_ll);
			sxy_ll = (LinearLayout) findViewById(R.id.sxy_ll);
			fxgl_ll = (LinearLayout) findViewById(R.id.fxgl_ll);
			khgl_ll = (LinearLayout) findViewById(R.id.khgl_ll);
			zhgl_ll = (LinearLayout) findViewById(R.id.zhgl_ll);
			ddgl_ll = (LinearLayout) findViewById(R.id.ddgl_ll);
			wd_ll = (LinearLayout) findViewById(R.id.wd_ll);
			ll05 = (LinearLayout) findViewById(R.id.ll05);
			fuzhu_ll1 = (LinearLayout) findViewById(R.id.fuzhu_ll1);
			gnjp_ll.setOnClickListener(btnClickListner);
			gjjp_ll.setOnClickListener(btnClickListner);
			jdyd_ll.setOnClickListener(btnClickListner);
			hcp_ll.setOnClickListener(btnClickListner);
			jdmp_ll.setOnClickListener(btnClickListner);
			hfcz_ll.setOnClickListener(btnClickListner);
			hbdt_ll.setOnClickListener(btnClickListner);
			wpt_ll.setOnClickListener(btnClickListner);
			sxy_ll.setOnClickListener(btnClickListner);
			fxgl_ll.setOnClickListener(btnClickListner);
			khgl_ll.setOnClickListener(btnClickListner);
			zhgl_ll.setOnClickListener(btnClickListner);
			ddgl_ll.setOnClickListener(btnClickListner);
			wd_ll.setOnClickListener(btnClickListner);
			queryUserInfo();
			showFX_KH();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �����û�Ȩ����ʾ�ͻ�������������
	private void showFX_KH() {
		try {
			if (!sp.getBoolean(SPkeys.loginState.getString(), false)) {
				ll05.setVisibility(View.GONE);
			} else {
				ll05.setVisibility(View.VISIBLE);
				if (sp.getString(SPkeys.showCustomer.getString(), "0").equals(
						"1")) {
					khgl_ll.setVisibility(View.VISIBLE);
				} else {// Ϊ�˱���һ��Ҳ
					khgl_ll.setVisibility(View.GONE);
					fuzhu_ll1.setVisibility(View.VISIBLE);
				}
				if (sp.getString(SPkeys.showDealer.toString(), "0").equals("1")) {
					fxgl_ll.setVisibility(View.VISIBLE);
				} else {
					fxgl_ll.setVisibility(View.GONE);
					fuzhu_ll1.setVisibility(View.VISIBLE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		showFX_KH();
	}

	// @Override
	// protected void onResume() {
	// // TODO Auto-generated method stub
	// super.onResume();
	// }

	@Override
	protected void onStart() {
		super.onStart();
	}

	View.OnClickListener btnClickListner = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			try {
				switch (v.getId()) {
				case R.id.imgBtn_gnjp:
				case R.id.gnjp_ll:
					startActivity(new Intent(context,
							ActivityInlandAirlineticket.class));
					break;
				case R.id.imgBtn_gjjp:
				case R.id.gjjp_ll:
					startActivity(new Intent(context,
							ActivityInternationalAirlineticket.class));
					break;
				case R.id.imgBtn_hbdt:
				case R.id.hbdt_ll:
					startActivity(new Intent(context,
							ActivityHangbandongtai.class));
					break;
				case R.id.imgBtn_jdyd:
				case R.id.jdyd_ll:
					startActivity(new Intent(context, ActivityHotel.class));
					break;
				case R.id.imgBtn_wpt:
				case R.id.wpt_ll:
					Intent intent = new Intent(context,
							Activity_Web_Frame.class);
					intent.putExtra(Activity_Web_Frame.TITLE, "΢ƽ̨");
					intent.putExtra(Activity_Web_Frame.URL, getResources()
							.getString(R.string.weipingtai_url));
					startActivity(intent);
					break;
				case R.id.imgBtn_hfcz:
				case R.id.hfcz_ll:
					startActivity(new Intent(context,
							ActivityHuafeichongzhi.class));
					break;
				case R.id.imgBtn_jdmp:
				case R.id.jdmp_ll:
					//startActivity(new Intent(context, Activity_Scenery.class));
//					startActivity(new Intent(context,com.jike.mpos.newversion.WelcomeActivity.class));

//					Intent intent5 = new Intent();
//					ComponentName componentName = new ComponentName("com.jike.mpos.newversion", "com.jike.mpos.newversion.WelcomeActivity");
//					intent5.setComponent(componentName);
//					startActivity(intent5);
					
					Intent intent5 = new Intent();
					intent5.setClassName(getApplication(), "com.jike.mpos.newversion.MposWelcomeActivity");
					startActivity(intent5);
					
					break;
				case R.id.imgBtn_sxy:
				case R.id.sxy_ll:
					Intent intent3 = new Intent(context,
							Activity_Web_Frame.class);
					intent3.putExtra(Activity_Web_Frame.TITLE, "��ѧԺ");
					intent3.putExtra(Activity_Web_Frame.URL, getResources()
							.getString(R.string.shangxueyuan_url));
					startActivity(intent3);
					break;
				case R.id.imgBtn_hcp:
				case R.id.hcp_ll:
					startActivity(new Intent(context, ActivityTrain.class));
					break;
				case R.id.imgBtn_fxgl:
				case R.id.fxgl_ll:
					if (!sp.getBoolean(SPkeys.loginState.getString(), false)) {
						startActivity(new Intent(context, Activity_Login.class));
						break;
					}
					Intent intent1 = new Intent(context,
							ActivityClientManage.class);
					intent1.putExtra(
							ActivityClientManageSetGrad.DISPLAY_TYPENAME_STRING,
							ActivityClientManageSetGrad.DEALER_DISPLAYNAME);
					startActivity(intent1);
					break;
				case R.id.imgBtn_khgl:
				case R.id.khgl_ll:
					if (!sp.getBoolean(SPkeys.loginState.getString(), false)) {
						startActivity(new Intent(context, Activity_Login.class));
						break;
					}
					Intent intent2 = new Intent(context,
							ActivityClientManage.class);
					intent2.putExtra(
							ActivityClientManageSetGrad.DISPLAY_TYPENAME_STRING,
							ActivityClientManageSetGrad.CUSTOMER_DISPLAYNAME);
					startActivity(intent2);
					break;
				case R.id.imgBtn_zhgl:
				case R.id.zhgl_ll:
					startActivity(new Intent(context,
							ActivityZhanghuchongzhi.class));
					break;
				case R.id.imgBtn_ddgl:
				case R.id.ddgl_ll:
					startActivity(new Intent(context, OrderActivity.class));
					break;
				case R.id.imgBtn_wd:
				case R.id.wd_ll:
					startActivity(new Intent(context, MineActivity.class));
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	private void queryUserInfo() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int utype = 0;
					MyApp ma = new MyApp(context);
					Platform pf = (Platform) ma.getHm().get(
							PackageKeys.PLATFORM.getString());
					String version = "";
					try {
						version = context.getPackageManager().getPackageInfo(
								context.getPackageName(), 0).versionName;
					} catch (NameNotFoundException e) {
						e.printStackTrace();
					}
					if (pf == Platform.B2B)
						utype = 1;
					else if (pf == Platform.B2C)
						utype = 2;
					String str = "{\"uname\":\""
							+ sp.getString(SPkeys.lastUsername.getString(), "")
							+ "\",\"upwd\":\""
							+ sp.getString(SPkeys.lastPassword.getString(), "")
							+ "\",\"utype\":\"" + utype + "\",\"version\":\""
							+ version + "\"}";
					String param = "action=userlogin&sitekey=&userkey="
							+ ma.getHm().get(PackageKeys.USERKEY.getString())
									.toString()
							+ "&str="
							+ str
							+ "&sign="
							+ CommonFunc.MD5(ma.getHm()
									.get(PackageKeys.USERKEY.getString())
									.toString()
									+ "userlogin" + str);
					loginReturnJson = HttpUtils.getJsonContent(
							ma.getServeUrl(), param);
					Log.v("loginReturnJson", loginReturnJson);
					Message msg = new Message();
					msg.what = 1;
					handler.sendMessage(msg);
				} catch (Exception exception) {
				}
			}
		}).start();
	}

	private Handler handler = new Handler() {// ���������ж��û��������Ƿ�ʧЧ
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:// ��ȡ��¼���ص�����

				JSONTokener jsonParser;
				jsonParser = new JSONTokener(loginReturnJson);
				try {
					JSONObject jsonObject = (JSONObject) jsonParser.nextValue();
					String state = jsonObject.getString("c");

					if (state.equals("0000")) {
						String content = jsonObject.getString("d");
						sp.edit()
								.putString(SPkeys.UserInfoJson.getString(),
										content).commit();

						// ���´��뽫�û���Ϣ�����л���SharedPreferences��
						UserInfo user = JSONHelper.parseObject(content,
								UserInfo.class);
						sp.edit()
								.putString(SPkeys.userid.getString(),
										user.getUserid()).commit();
						sp.edit()
								.putString(SPkeys.username.getString(),
										user.getUsername()).commit();
						sp.edit()
								.putString(SPkeys.amount.getString(),
										user.getAmmount()).commit();
						sp.edit()
								.putString(SPkeys.siteid.getString(),
										user.getSiteid()).commit();
						sp.edit()
								.putString(SPkeys.userphone.getString(),
										user.getMobile()).commit();
						sp.edit()
								.putString(SPkeys.useremail.getString(),
										user.getEmail()).commit();
						sp.edit()
								.putBoolean(SPkeys.loginState.getString(), true)
								.commit();
					} else {
						sp.edit().remove(SPkeys.loginState.getString())
						.commit();
						sp.edit().remove(SPkeys.UserInfoJson.getString())
								.commit();
						sp.edit().remove(SPkeys.lastUsername.getString())
								.commit();
						sp.edit().remove(SPkeys.lastPassword.getString())
								.commit();
						sp.edit().remove(SPkeys.autoLogin.getString()).commit();
						sp.edit().remove(SPkeys.userid.getString()).commit();
						sp.edit().remove(SPkeys.username.getString()).commit();
						sp.edit().remove(SPkeys.siteid.getString()).commit();
						sp.edit().remove(SPkeys.amount.getString()).commit();
						sp.edit().remove(SPkeys.userphone.getString()).commit();
						sp.edit().remove(SPkeys.useremail.getString()).commit();
						if (state.equals("9999")) {// ��Ҫ��ǿ�Ƹ���
							MyApp ma = new MyApp(context);
							UpdateManager manager = new UpdateManager(context,
									ma.getHm()
											.get(PackageKeys.UPDATE_NOTE
													.getString()).toString());
							manager.checkForUpdates(false);
						}
						if (state.equals("1003")) {// �û����������
							sp.edit().putString(SPkeys.userid.getString(), "")
									.commit();
							sp.edit()
									.putString(SPkeys.username.getString(), "")
									.commit();
							sp.edit()
									.putBoolean(SPkeys.loginState.getString(),
											false).commit();
						}
						if (state.equals("1919")) {
							startActivity(new Intent(context,
									Activity_Login.class));
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	private long mExitTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if ((System.currentTimeMillis() - mExitTime) > 2000) {
				Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();
			} else {
				((MyApplication) getApplication()).exit();
				android.os.Process.killProcess(android.os.Process.myPid());
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
