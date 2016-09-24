/* MainActivity.java -- A activity file
 *
 * Copyright (c) 2014-2016, ZhangXuelian(Mark.Zhang)<cnzhuhai at gmail dot com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   * Neither the name of Redis nor the names of its contributors may be used
 *     to endorse or promote products derived from this software without
 *     specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.example.mainframe;
import com.mk.util.myDialog;

import android.os.Bundle;
import android.app.ActivityGroup;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;

@SuppressWarnings("deprecation")
public class MainActivity extends ActivityGroup implements OnClickListener{
	private LinearLayout container = null;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.container = ((LinearLayout) findViewById(R.id.container));
		launchActivity(CamListActivity.class);
	}

	private void launchActivity(Class<?> className) {
		container.removeAllViews();
		Intent intent = new Intent(this, className);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		Window window = getLocalActivityManager().startActivity(
				"a", intent);
		View view = window.getDecorView();
		container.addView(view,LayoutParams.MATCH_PARENT);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.rb_camera:
			launchActivity(CamListActivity.class);
			break;
		case R.id.rb_alarm:
			launchActivity(CamFileListActivity.class);
			break;
		case R.id.rb_album:
			//if (true) {
			//	launchActivity(CamFileListActivity.class);
			//}
			break;
			
		// 顶端按钮
		case R.id.setting:
			Intent i = new Intent(this,SettingActivity.class);
			startActivity(i);
			break;
		
		//case R.id.exit:
		//	new myDialog(this).show();// 添加联系人
		//	break;
		default:
			break;
		}
	}
	
}
