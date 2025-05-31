package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() {
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public RatingCompat[] newArray(int i10) {
            return new RatingCompat[i10];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    RatingCompat(int i10, float f10) {
        this.mRatingStyle = i10;
        this.mRatingValue = f10;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null && Build.VERSION.SDK_INT >= 19) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompat = newHeartRating(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompat = newThumbRating(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = newUnratedRating(ratingStyle);
            }
            ratingCompat.mRatingObj = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z10) {
        return new RatingCompat(1, z10 ? 1.0f : 0.0f);
    }

    public static RatingCompat newPercentageRating(float f10) {
        if (f10 >= 0.0f && f10 <= 100.0f) {
            return new RatingCompat(6, f10);
        }
        Log.e(TAG, "Invalid percentage-based rating value");
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.RatingCompat newStarRating(int r4, float r5) {
        /*
            r0 = 3
            r1 = 0
            java.lang.String r2 = "Rating"
            if (r4 == r0) goto L_0x002c
            r0 = 4
            if (r4 == r0) goto L_0x0029
            r0 = 5
            if (r4 == r0) goto L_0x0026
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "Invalid rating style ("
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = ") for a star rating"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x0022:
            android.util.Log.e(r2, r4)
            return r1
        L_0x0026:
            r0 = 1084227584(0x40a00000, float:5.0)
            goto L_0x002e
        L_0x0029:
            r0 = 1082130432(0x40800000, float:4.0)
            goto L_0x002e
        L_0x002c:
            r0 = 1077936128(0x40400000, float:3.0)
        L_0x002e:
            r3 = 0
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x003e
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            android.support.v4.media.RatingCompat r0 = new android.support.v4.media.RatingCompat
            r0.<init>(r4, r5)
            return r0
        L_0x003e:
            java.lang.String r4 = "Trying to set out of range star-based rating"
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.RatingCompat.newStarRating(int, float):android.support.v4.media.RatingCompat");
    }

    public static RatingCompat newThumbRating(boolean z10) {
        return new RatingCompat(2, z10 ? 1.0f : 0.0f);
    }

    public static RatingCompat newUnratedRating(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i10, RATING_NOT_RATED);
            default:
                return null;
        }
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        return (this.mRatingStyle != 6 || !isRated()) ? RATING_NOT_RATED : this.mRatingValue;
    }

    public Object getRating() {
        Rating rating;
        if (this.mRatingObj == null && Build.VERSION.SDK_INT >= 19) {
            if (isRated()) {
                int i10 = this.mRatingStyle;
                switch (i10) {
                    case 1:
                        rating = Rating.newHeartRating(hasHeart());
                        break;
                    case 2:
                        rating = Rating.newThumbRating(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        rating = Rating.newStarRating(i10, getStarRating());
                        break;
                    case 6:
                        rating = Rating.newPercentageRating(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                rating = Rating.newUnratedRating(this.mRatingStyle);
            }
            this.mRatingObj = rating;
        }
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int i10 = this.mRatingStyle;
        return ((i10 == 3 || i10 == 4 || i10 == 5) && isRated()) ? this.mRatingValue : RATING_NOT_RATED;
    }

    public boolean hasHeart() {
        return this.mRatingStyle == 1 && this.mRatingValue == 1.0f;
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Rating:style=");
        sb2.append(this.mRatingStyle);
        sb2.append(" rating=");
        float f10 = this.mRatingValue;
        sb2.append(f10 < 0.0f ? "unrated" : String.valueOf(f10));
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }
}
