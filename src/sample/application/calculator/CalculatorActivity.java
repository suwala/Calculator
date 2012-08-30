package sample.application.calculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {

	public Double i =(double) 0,j=0.0;
	String enzan,hoji;
	
	String strTemp="";
	String strResult="0";
	Integer operator =0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }
    
    public void numKeyOnClick(View v){
    	
    	//-----------教科書-----------↓
    	
    	String strInKey = (String)((Button)v).getText();
    	
    	//".".equals(strInKey)
    	if(strInKey.equals(".")){
    		if(this.strTemp.length() == 0){
    			this.strTemp = "0.";
    		}else{
    			if(this.strTemp.indexOf(".") == -1){
    				this.strTemp=this.strTemp+".";
    			}
    		}    		
    	}else{
    		this.strTemp = this.strTemp+strInKey;
    	}
    	
    	//this.strTempはいらない？直接thisしる
    	this.showNumber(this.strTemp);
    	
    	//------教科書------↑
    	
    	
    	/*
    	Button button = (Button)v;   	
    	
    	TextView tv = (TextView)findViewById(R.id.displayPanel);
 
    	    	
    	//String 比較めそっどeauals
    	
    	if(tv.getText().toString().equals("0")){
    		if(button.getId() == R.id.keypadDot){
    			if(tv.getText().toString().indexOf(".") == -1){
    				tv.setText((String) tv.getText()+button.getText());
    				Log.d("点が含まれない","");
    			}else
    				;
    		}else{
    			tv.setText(button.getText());//上書き
    		}
    		
    	}else{
    		if(tv.getText().toString().indexOf(".") == -1){
				tv.setText((String) tv.getText()+button.getText());
				Log.d("点が含まれない","");
			}else
				; 		
    	}
    	
    	//0が表示されてる時に.が押された場合
    	if(tv.getText().toString().equals("0")&&button.getId() == R.id.keypadDot)
    			tv.setText((String) tv.getText()+button.getText());
    	*/
    	
    	/*
    	switch (button.getId()){
    	case R.id.keypadDot:
    		if(tv.getText().toString().equals("0")){
    			tv.setText((String) tv.getText()+button.getText());
    		}else{
    			if(tv.getText().toString().indexOf(".") == -1){
    				tv.setText((String) tv.getText()+button.getText());
    			}
    		}
    		break;
    	default:
    		if(tv.getText().toString().equals("0")){
    			if(button.getId() == R.id.keypad0){
    				;
    			}else{
    				tv.setText(button.getText());
    			}
    		}else{
    			tv.setText((String) tv.getText()+button.getText());
    		}
    		break;
    	}
 
		this.i = Double.valueOf(tv.getText().toString());
				
    	Log.d("tv",tv.getText().toString());
    	Log.d("tv_i:j",i.toString()+":"+j.toString());
    	
    	
    	*/
    }
    
    public void functionKeyonClick(){
    	
    	//保留
    }
    
    public void operatorKeyOnClick(View v){
    	if(operator!= 0){
    		if(strTemp.length()>0){
    			this.strResult= this.doCalc();
    			this.showNumber(strResult);
    		}
    	}
    	else{
    		if(strTemp.length()>0){
    			strResult = strTemp;
    		}
    	}
    	
    	strTemp ="";
    	
    	if(v.getId()==R.id.keypadEq){
    		operator=0;
    	}else{
    		operator=v.getId();
    		}
    }
    
    private void showNumber(String strNum){
    	
    	DecimalFormat form = new DecimalFormat("#,##0");
    	String strDecimal ="";
    	String strInt="";
    	String fText="";
    	
    	if(strNum.length()>0){
    		int decimalPoint  = strNum.indexOf(".");
    		if(decimalPoint>-1){
    			strDecimal = strNum.substring(decimalPoint);
    			strInt = strNum.substring(0,decimalPoint);
    		}else{
    			strInt = strNum;
    		}
    		fText=form.format(Double.parseDouble(strInt))+strDecimal;    		
    	}else{
    		fText="0";
    	}
    	
    	((TextView)findViewById(R.id.displayPanel)).setText(fText);
    }
    
     
    private String doCalc(){
    	/*
    	BigDecimal bd = new BigDecimal(this.j);
    	
    	BigDecimal i = new BigDecimal(this.i);
    	    	
    	if(enzan.equals("+"))
    		bd = bd.add(i);
    	if(enzan.equals("-"))
    		bd = bd.subtract(i);
    	if(enzan.equals("*"))
    		bd = bd.multiply(i);
    	if(enzan.equals("/"))
    		bd = bd.divide(i);
    	

//    	if(j-j.intValue()==0)
//    		return String.valueOf(j.intValue());
    	
    	Log.d("enzan",bd.toString());
    	return bd.toString();
    	//if (double)j-(int)j == 0なら整数？; "."消去可能？(int)で返す？
    }---------教科書↓-----------*/
    	
    	BigDecimal bd1 = new BigDecimal(strResult);
    	BigDecimal bd2 = new BigDecimal(strTemp);
    	BigDecimal result = BigDecimal.ZERO;
    	
    	switch(operator){
    	case R.id.keypadAdd:
    		result = bd1.add(bd2);
    		break;
    	case R.id.keypadSub:
    		result = bd1.subtract(bd2);
    		break;
    	case R.id.keypadMulti:
    		result = bd1.multiply(bd2);
    		break;
    	case R.id.keypadDiv:
    		if(bd2.equals(BigDecimal.ZERO)){
    			result = bd1.divide(bd2,12,3);
    		}else{
    			Toast toast = Toast.makeText(this,R.string.toast_div_by_zero,10000);
    			toast.show();
    		}
    		break;
    	}
    	
    	if(result.toString().indexOf(".")>=0){
    		return result.toString().replaceAll("¥¥.0+$|0+$", "");
    	}else{
    		return result.toString();
    	}
    		
    		
    	}
    	
    	
}
