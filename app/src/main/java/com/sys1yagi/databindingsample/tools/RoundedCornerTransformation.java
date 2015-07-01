package com.sys1yagi.databindingsample.tools;

import com.squareup.picasso.Transformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class RoundedCornerTransformation implements Transformation {

    private float corner;

    public RoundedCornerTransformation(float corner) {
        this.corner = corner;
    }

    @Override
    public Bitmap transform(Bitmap bitmap) {
        Bitmap b = getRoundedCornerBitmap(bitmap, corner,
                bitmap.getWidth(), bitmap.getHeight());
        bitmap.recycle();

        Log.d("moge", "transform");
        return b;
    }

    @Override
    public String key() {
        return "corner()";
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap input,
            float cornerRadius, int w, int h) {

        Bitmap output = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, w, h);
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(input, 0, 0, paint);

        return output;
    }

}
