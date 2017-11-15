package net.daum.www.havespot.utils;

import android.graphics.drawable.Drawable;

/**
 * Created by LYS on 2017-11-12.
 */

public class StoreDAO {
    private Drawable storeImg;
    private Drawable storeDetail;
    private String storeName;
    private String storeAddress;
    private String storeTime;
    private String storeTell;
    private String storeIntro;
    private int storeLike;

    /* StoreDetail page 에서 사용*/
    public StoreDAO(Drawable storeDetail, String storeName, String storeAddress, int storeLike, String storeTime, String storeTell, String storeIntro) {
        this.storeDetail = storeDetail;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeLike = storeLike;
        this.storeTime = storeTime;
        this.storeTell = storeTell;
        this.storeIntro = storeIntro;
    }

    /* StoreList page 에서 사용 */
    public StoreDAO(Drawable storeImg, String storeName, String storeAddress, int storeLike) {
        this.storeImg = storeImg;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeLike = storeLike;
    }

    public StoreDAO() {

    }

    public Drawable getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(Drawable storeDetail) {
        this.storeDetail = storeDetail;
    }

    public String getStoreIntro() {
        return storeIntro;
    }

    public void setStoreIntro(String storeIntro) {
        this.storeIntro = storeIntro;
    }


    public String getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(String storeTime) {
        this.storeTime = storeTime;
    }

    public String getStoreTell() {
        return storeTell;
    }

    public void setStoreTell(String storeTell) {
        this.storeTell = storeTell;
    }

    public Drawable getStoreImg() {
        return storeImg;
    }

    public void setStoreImg(Drawable storeImg) {
        this.storeImg = storeImg;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStoreLike() {
        return storeLike;
    }

    public void setStoreLike(int storeLike) {
        this.storeLike = storeLike;
    }
}
