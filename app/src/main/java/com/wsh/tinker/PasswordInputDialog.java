package com.wsh.tinker;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.wsh.tinker.view.PswInputView;

/**
 * 弹出密码输入窗口
 * Created by wangshanhai on 2017/2/23
 */

public class PasswordInputDialog {
    Context context;
    DialogCallback dialogcallback;
    Dialog dialog;

    private ImageView iv_close;
    private PswInputView psw_input;



    /**
     * init the dialog
     *
     * @return
     */
    public PasswordInputDialog(Context con) {
        this.context = con;
        dialog = new Dialog(context, R.style.dialog);
        dialog.setContentView(R.layout.password_input_dialog);
        iv_close = (ImageView) dialog.findViewById(R.id.iv_close);
        psw_input = (PswInputView) dialog.findViewById(R.id.psw_input);

        initListener();
    }

    private void initListener() {

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        psw_input.setInputCallBack(new PswInputView.InputCallBack() {
            @Override
            public void onInputFinish(final String result) {
              //  Toast.makeText(context,result, Toast.LENGTH_SHORT).show();

                psw_input.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                     //   psw_input.clearResult();
                        dismiss();
                        dialogcallback.dialogOk(result);
                    }
                },1000);
            }
        });

    }

    public interface DialogCallback {
        public void dialogOk(String passwd);
    }

    public void setDialogCallback(DialogCallback dialogCallback) {
        this.dialogcallback = dialogCallback;
    }

    public void show() {
        dialog.show();
    }

    public void hide() {
        dialog.hide();
    }

    public void dismiss() {
        dialog.dismiss();
    }
}