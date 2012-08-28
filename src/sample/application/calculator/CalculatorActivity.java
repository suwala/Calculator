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

public class CalculatorActivity extends Activity {

	public Double i =(double) 0,j=0.0;
	String enzan,hoji;
	
	String strTemp="";
	
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
    	
    	//-----------教科書------------
    	
    	String strInKey = (String)((Button)v).getText();
    	
    	//".".equals(strInKey)
    	if(strInKey.equals(".")){
    		if(this.strTemp.length() == 0){
    			this.strTemp = "0.";
    		}else{
    			if(strTemp.indexOf(".") == -1){
    				strTemp=strTemp+".";
    			}
    		}    		
    	}else{
    		this.strTemp = this.strTemp+strInKey;
    	}
    	
    	//this.strTempはいらない？直接thisしる
    	this.showNumber(this.strTemp);
    	
    	//------教科書------
    	
    	Button button = (Button)v;   	
    	
    	TextView tv = (TextView)findViewById(R.id.displayPanel);
    	//ここまで
    	
    	/*	/////
    	    	
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
    	
    	
    }
    
    public void operatorKeyOnClick(View v){
    	Button btn = (Button)v;
    	
    	
    	
    	TextView tv = (TextView)findViewById(R.id.displayPanel);
    	
    	
    	
    	//Log.d("Integer",iii.doubleValue());

    	//i = Integer.valueOf(tv.getText().toString());
    	
    	
    	
//    	try{
//    	switch(btn.getId()){
//    	case R.id.keypadAdd:
//    		i = i+Integer.valueOf(tv.getText().toString());
//    		Log.d("enzan",enzan);
//    		break;
//    	case R.id.keypadSub:
//    		i = i-Integer.valueOf(tv.getText().toString());
//    		break;
//    	case R.id.keypadMulti:
//    		i = i*Integer.valueOf(tv.getText().toString());
//    		break;
//    	case R.id.keypadDiv:
//    		i = i/Integer.valueOf(tv.getText().toString());
//    	
//    	}
//    	}catch(Exception e){
//    		tv.setText("エラーです");
//    	}
    	
    	
    	try{
        	switch(btn.getId()){
        	case R.id.keypadAdd:
        		enzan = btn.getText().toString();
        		j=Double.valueOf(tv.getText().toString());
        		tv.setText("0");
        		hoji = tv.getText().toString();
        		tv = (TextView)findViewById(R.id.enzan);
        		tv.setText("+");
        		Log.d("enzan",enzan);
        		break;
        	case R.id.keypadSub:
        		enzan = btn.getText().toString();
        		j=Double.valueOf(tv.getText().toString());
        		hoji = tv.getText().toString();
        		tv.setText("0");
        		tv = (TextView)findViewById(R.id.enzan);
        		tv.setText("-");        		
        		break;
        	case R.id.keypadMulti:
        		enzan = btn.getText().toString();
        		j=Double.valueOf(tv.getText().toString());
        		hoji = tv.getText().toString();
        		tv.setText("0");
        		tv = (TextView)findViewById(R.id.enzan);
        		tv.setText("*");
        		break;
        	case R.id.keypadDiv:
        		enzan = btn.getText().toString();
        		j=Double.valueOf(tv.getText().toString());
        		hoji = tv.getText().toString();
        		tv.setText("0");
        		tv = (TextView)findViewById(R.id.enzan);
        		tv.setText("/");
        		break;        	
        	case R.id.keypadEq:
        		//i=Integer.valueOf(tv.getText().toString());
        		tv.setText(doCalc());
        		
        		break;
        	}
        	}catch(Exception e){
        		tv.setText("エラーです");
        	}
    	
    	
    	//tv.setText(i.toString());
    	
  	
    	
    	
    	//Integer.valueOf(str);
    	
    	
    	
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
    	

    	if(j-j.intValue()==0)
    		return String.valueOf(j.intValue());
    	
    	Log.d("enzan",bd.toString());
    	return bd.toString();
    	//if (double)j-(int)j == 0なら整数？; "."消去可能？(int)で返す？
    }
}
