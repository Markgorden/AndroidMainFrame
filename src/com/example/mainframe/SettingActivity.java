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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

@SuppressLint("NewApi")
public class SettingActivity extends Activity implements OnClickListener{
	private View mExitMenuView;
	private View mExitMenuView1;
	private Button mExitCancleBtn;
	private Button mExitConfirmBtn;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_settings_fragment);
		
		
		
		// exit window
		
	   LayoutInflater layout = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	   mExitMenuView = (LinearLayout)layout.inflate(R.layout.common_menu_dialog_2btn_layout, null);

		mExitCancleBtn = (Button) mExitMenuView.findViewById(R.id.btnCancel);
		mExitConfirmBtn = (Button) mExitMenuView
				.findViewById(R.id.btn_exit_comfirm);
		mExitCancleBtn.setOnClickListener(this);
		mExitConfirmBtn.setOnClickListener(this);
		
		mExitMenuView1 = (LinearLayout)layout.inflate(R.layout.common_menu_dialog_2btn_layout, null);

		
	}
	
	private Dialog mExitDialog;
	private Dialog mExitDialog1;
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.exit_app:
			//if (mExitDialog == null)
			//	mExitDialog = com.sosocam.util.DialogUtil.getMenuDialog(this,mExitMenuView,Gravity.BOTTOM);
			//mExitDialog.show();
			
			//if (mExitDialog1 == null)
			//	mExitDialog1 = com.sosocam.util.DialogUtil.getMenuDialog(this,mExitMenuView1,Gravity.TOP);
			//mExitDialog1.show();
			
			if (mExitDialog1 == null)
				mExitDialog1 = com.mk.util.DialogUtil.getAlertDialog(this,mExitMenuView1);
			mExitDialog1.show();
			
			
			
			
			break;
		case R.id.btnCancel:
			if (mExitDialog != null && mExitDialog.isShowing())
				mExitDialog.dismiss();
			break;
		case R.id.btn_exit_comfirm:
			if(mExitDialog.isShowing()){
				mExitDialog.cancel();
			}
			break;
		default:
			break;
		}
	}
}
