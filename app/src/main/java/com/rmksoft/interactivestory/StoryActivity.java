package com.rmksoft.interactivestory;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rmksoft.interactivestory.model.Page;
import com.rmksoft.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {
private Story mStory=new Story();
private ImageView mImageView;
private TextView mTextView;
private Button mChoice1;
private Button mChoice2;
private String mName;
    private Page mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent=getIntent();
        mName =intent.getStringExtra(getString(R.string.key_name));
if(mName == null){

    mName="Friend";
}
mImageView=(ImageView) findViewById(R.id.storyImageView);
mTextView=(TextView) findViewById(R.id.stortTextView);
mChoice1=(Button)findViewById(R.id.choiceButton1);
mChoice2=(Button)findViewById(R.id.choiceButton2);
loadPage(0);
    }

private void loadPage(int choice){
 mCurrentPage=mStory.getPage(choice);
    Drawable drawable=getResources().getDrawable(mCurrentPage.getImageId());
    mImageView.setImageDrawable(drawable);
    String pageText=mCurrentPage.getText();
    pageText=String.format(pageText,mName);
    mTextView.setText(pageText);
  ///
  if(mCurrentPage.isFinal()){
      Toast.makeText(this,"Final",Toast.LENGTH_LONG);
      mChoice1.setVisibility(View.INVISIBLE);
      mChoice2.setText("Play Again");
      mChoice2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });
  }else {
      Toast.makeText(this,"Not Final",Toast.LENGTH_LONG);
      mChoice1.setText(mCurrentPage.getChoice1().getText());
      mChoice2.setText(mCurrentPage.getChoice2().getText());


      mChoice1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(StoryActivity.this,"Choice1",Toast.LENGTH_LONG);
              int nextPage = mCurrentPage.getChoice1().getNextPage();

              loadPage(nextPage);
          }
      });
      mChoice2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(StoryActivity.this,"Choice2",Toast.LENGTH_LONG);

              int nextPage = mCurrentPage.getChoice2().getNextPage();
              loadPage(nextPage);
          }
      });
      ///
  }


}

}
