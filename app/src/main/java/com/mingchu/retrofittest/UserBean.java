package com.mingchu.retrofittest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2017/3/4.
 */

public class UserBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 62
     * score : 0
     * balance : 0
     * results : {"userid":"54442","qjCode":"","nickname":"何峻","avatar":"http://image.xinliji.me/Fo2Fiog_QaglQYbUVs2lqKkNGFdM","slogan":"让我们一起拨云见日","audio":"http://image.xinliji.me/o_1arde421m1m0a1lvg1qnsogt17c9q.mp3","audioLength":"","gender":"0","score":"280","dob":"1973-10-10","constellation":"7","height":"160","weight":"60","role":"0","emotion":"0","occupation":"","city":"上海","label":"","hobby":"","like":"","hate":"","likeCnt":"126","consultantCnt":"19","isLiked":"1","isFollowed":"0","isInBlacklist":"0","groupCnt":"10","cmtCnt":"59","isAnchor":"0","distance":"0","lastLoginLatitude":"31.217437","lastLoginLongitude":"121.412012","lastLoginTime":1486625319,"isConsultant":"1","catgs":"情绪困扰、心理障碍、社交职场","honor":"国家二级心理咨询师","resume":"中国心理卫生协会会员、上海心理协会会员、国家二级心理咨询师、EAP咨询师、MBA。擅长认知行为疗法、短焦、精神分析、意象对话、沙盘、催眠和家庭治疗。长程咨询个案招募中。","qualification":"国二","qualificationPhotos":"http://image.xinliji.me/http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1a91g4n07rdrt0b1kfd5r8b55i.jpg","fee":"800","reserveFee":500,"clinicName":"花房","address":"","lon":"","lat":"","isNamePending":"0","isQuaPending":"0","nameDraft":"","quaDraft":"","quaPhotosDraft":"","videoProfile":"http://video.xinliji.me/o_1a9cbgbtt1tvv1e9h10tl13p7k7ua.mp4","webcallPrice":"50","canShare":"1","shareUrl":"http://app.xinliji.me/consultant?consultantid=54442","shareTitle":"【我心】注册咨询师","shareContent":"相约【我心】，我是您的专属心理咨询师 何峻","age":43,"catgsRating":[{"key":"BAOZAO","label":"暴躁","rating":"12"},{"key":"EMOTION_OTHER","label":"其他","rating":"1"},{"key":"GUPI","label":"孤僻","rating":"3"},{"key":"JIAOLV","label":"焦虑","rating":"6"},{"key":"KAOSHIJIAOLV","label":"考试焦虑","rating":"1"},{"key":"LIANAI","label":"恋爱困惑","rating":"8"},{"key":"MOOD_OTHER","label":"其他","rating":"6"},{"key":"PSYCHOLOGICAL_OTHER","label":"其他","rating":"4"},{"key":"RENJIGUANXI","label":"人际关系","rating":"2"},{"key":"RENSHENGGUIHUA","label":"人生规划","rating":"2"}],"topComment":{"id":"64699","objectId":"54442","objectType":"consultant","userid":"89343","name":"婷**","avatar":"http://icon.xinliji.me//avatar_0_63.png","replyToUserid":"","replyToUserName":"","replyToContent":"","content":"医生很好，我很喜欢她呦☺️","createdDate":1470893139,"consultantTags":"自卑","rating":"5"},"continuedPercent":"50.00","timelyPercent":"53.85","giftNum":"100"}
     */

    private String errorCode;
    private String errorStr;
    private String resultCount;
    private String score;
    private String balance;
    private ResultsBean results;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorStr() {
        return errorStr;
    }

    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }

    public String getResultCount() {
        return resultCount;
    }

    public void setResultCount(String resultCount) {
        this.resultCount = resultCount;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * userid : 54442
         * qjCode :
         * nickname : 何峻
         * avatar : http://image.xinliji.me/Fo2Fiog_QaglQYbUVs2lqKkNGFdM
         * slogan : 让我们一起拨云见日
         * audio : http://image.xinliji.me/o_1arde421m1m0a1lvg1qnsogt17c9q.mp3
         * audioLength :
         * gender : 0
         * score : 280
         * dob : 1973-10-10
         * constellation : 7
         * height : 160
         * weight : 60
         * role : 0
         * emotion : 0
         * occupation :
         * city : 上海
         * label :
         * hobby :
         * like :
         * hate :
         * likeCnt : 126
         * consultantCnt : 19
         * isLiked : 1
         * isFollowed : 0
         * isInBlacklist : 0
         * groupCnt : 10
         * cmtCnt : 59
         * isAnchor : 0
         * distance : 0
         * lastLoginLatitude : 31.217437
         * lastLoginLongitude : 121.412012
         * lastLoginTime : 1486625319
         * isConsultant : 1
         * catgs : 情绪困扰、心理障碍、社交职场
         * honor : 国家二级心理咨询师
         * resume : 中国心理卫生协会会员、上海心理协会会员、国家二级心理咨询师、EAP咨询师、MBA。擅长认知行为疗法、短焦、精神分析、意象对话、沙盘、催眠和家庭治疗。长程咨询个案招募中。
         * qualification : 国二
         * qualificationPhotos : http://image.xinliji.me/http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1a91g4n07rdrt0b1kfd5r8b55i.jpg
         * fee : 800
         * reserveFee : 500
         * clinicName : 花房
         * address :
         * lon :
         * lat :
         * isNamePending : 0
         * isQuaPending : 0
         * nameDraft :
         * quaDraft :
         * quaPhotosDraft :
         * videoProfile : http://video.xinliji.me/o_1a9cbgbtt1tvv1e9h10tl13p7k7ua.mp4
         * webcallPrice : 50
         * canShare : 1
         * shareUrl : http://app.xinliji.me/consultant?consultantid=54442
         * shareTitle : 【我心】注册咨询师
         * shareContent : 相约【我心】，我是您的专属心理咨询师 何峻
         * age : 43
         * catgsRating : [{"key":"BAOZAO","label":"暴躁","rating":"12"},{"key":"EMOTION_OTHER","label":"其他","rating":"1"},{"key":"GUPI","label":"孤僻","rating":"3"},{"key":"JIAOLV","label":"焦虑","rating":"6"},{"key":"KAOSHIJIAOLV","label":"考试焦虑","rating":"1"},{"key":"LIANAI","label":"恋爱困惑","rating":"8"},{"key":"MOOD_OTHER","label":"其他","rating":"6"},{"key":"PSYCHOLOGICAL_OTHER","label":"其他","rating":"4"},{"key":"RENJIGUANXI","label":"人际关系","rating":"2"},{"key":"RENSHENGGUIHUA","label":"人生规划","rating":"2"}]
         * topComment : {"id":"64699","objectId":"54442","objectType":"consultant","userid":"89343","name":"婷**","avatar":"http://icon.xinliji.me//avatar_0_63.png","replyToUserid":"","replyToUserName":"","replyToContent":"","content":"医生很好，我很喜欢她呦☺️","createdDate":1470893139,"consultantTags":"自卑","rating":"5"}
         * continuedPercent : 50.00
         * timelyPercent : 53.85
         * giftNum : 100
         */

        private String userid;
        private String qjCode;
        private String nickname;
        private String avatar;
        private String slogan;
        private String audio;
        private String audioLength;
        private String gender;
        private String score;
        private String dob;
        private String constellation;
        private String height;
        private String weight;
        private String role;
        private String emotion;
        private String occupation;
        private String city;
        private String label;
        private String hobby;
        private String like;
        private String hate;
        private String likeCnt;
        private String consultantCnt;
        private String isLiked;
        private String isFollowed;
        private String isInBlacklist;
        private String groupCnt;
        private String cmtCnt;
        private String isAnchor;
        private String distance;
        private String lastLoginLatitude;
        private String lastLoginLongitude;
        private String isConsultant;
        private String catgs;
        private String honor;
        private String resume;
        private String qualification;
        private String qualificationPhotos;
        private String fee;
        private String clinicName;
        private String address;
        private String lon;
        private String lat;
        private String isNamePending;
        private String isQuaPending;
        private String nameDraft;
        private String quaDraft;
        private String quaPhotosDraft;
        private String videoProfile;
        private String webcallPrice;
        private String canShare;
        private String shareUrl;
        private String shareTitle;
        private String shareContent;
        private TopCommentBean topComment;
        private String continuedPercent;
        private String timelyPercent;
        private String giftNum;
        private List<CatgsRatingBean> catgsRating;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getQjCode() {
            return qjCode;
        }

        public void setQjCode(String qjCode) {
            this.qjCode = qjCode;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getAudioLength() {
            return audioLength;
        }

        public void setAudioLength(String audioLength) {
            this.audioLength = audioLength;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getEmotion() {
            return emotion;
        }

        public void setEmotion(String emotion) {
            this.emotion = emotion;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getHate() {
            return hate;
        }

        public void setHate(String hate) {
            this.hate = hate;
        }

        public String getLikeCnt() {
            return likeCnt;
        }

        public void setLikeCnt(String likeCnt) {
            this.likeCnt = likeCnt;
        }

        public String getConsultantCnt() {
            return consultantCnt;
        }

        public void setConsultantCnt(String consultantCnt) {
            this.consultantCnt = consultantCnt;
        }

        public String getIsLiked() {
            return isLiked;
        }

        public void setIsLiked(String isLiked) {
            this.isLiked = isLiked;
        }

        public String getIsFollowed() {
            return isFollowed;
        }

        public void setIsFollowed(String isFollowed) {
            this.isFollowed = isFollowed;
        }

        public String getIsInBlacklist() {
            return isInBlacklist;
        }

        public void setIsInBlacklist(String isInBlacklist) {
            this.isInBlacklist = isInBlacklist;
        }

        public String getGroupCnt() {
            return groupCnt;
        }

        public void setGroupCnt(String groupCnt) {
            this.groupCnt = groupCnt;
        }

        public String getCmtCnt() {
            return cmtCnt;
        }

        public void setCmtCnt(String cmtCnt) {
            this.cmtCnt = cmtCnt;
        }

        public String getIsAnchor() {
            return isAnchor;
        }

        public void setIsAnchor(String isAnchor) {
            this.isAnchor = isAnchor;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getLastLoginLatitude() {
            return lastLoginLatitude;
        }

        public void setLastLoginLatitude(String lastLoginLatitude) {
            this.lastLoginLatitude = lastLoginLatitude;
        }

        public String getLastLoginLongitude() {
            return lastLoginLongitude;
        }

        public void setLastLoginLongitude(String lastLoginLongitude) {
            this.lastLoginLongitude = lastLoginLongitude;
        }

        public String getIsConsultant() {
            return isConsultant;
        }

        public void setIsConsultant(String isConsultant) {
            this.isConsultant = isConsultant;
        }

        public String getCatgs() {
            return catgs;
        }

        public void setCatgs(String catgs) {
            this.catgs = catgs;
        }

        public String getHonor() {
            return honor;
        }

        public void setHonor(String honor) {
            this.honor = honor;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getQualificationPhotos() {
            return qualificationPhotos;
        }

        public void setQualificationPhotos(String qualificationPhotos) {
            this.qualificationPhotos = qualificationPhotos;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getClinicName() {
            return clinicName;
        }

        public void setClinicName(String clinicName) {
            this.clinicName = clinicName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getIsNamePending() {
            return isNamePending;
        }

        public void setIsNamePending(String isNamePending) {
            this.isNamePending = isNamePending;
        }

        public String getIsQuaPending() {
            return isQuaPending;
        }

        public void setIsQuaPending(String isQuaPending) {
            this.isQuaPending = isQuaPending;
        }

        public String getNameDraft() {
            return nameDraft;
        }

        public void setNameDraft(String nameDraft) {
            this.nameDraft = nameDraft;
        }

        public String getQuaDraft() {
            return quaDraft;
        }

        public void setQuaDraft(String quaDraft) {
            this.quaDraft = quaDraft;
        }

        public String getQuaPhotosDraft() {
            return quaPhotosDraft;
        }

        public void setQuaPhotosDraft(String quaPhotosDraft) {
            this.quaPhotosDraft = quaPhotosDraft;
        }

        public String getVideoProfile() {
            return videoProfile;
        }

        public void setVideoProfile(String videoProfile) {
            this.videoProfile = videoProfile;
        }

        public String getWebcallPrice() {
            return webcallPrice;
        }

        public void setWebcallPrice(String webcallPrice) {
            this.webcallPrice = webcallPrice;
        }

        public String getCanShare() {
            return canShare;
        }

        public void setCanShare(String canShare) {
            this.canShare = canShare;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getShareTitle() {
            return shareTitle;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }

        public String getShareContent() {
            return shareContent;
        }

        public void setShareContent(String shareContent) {
            this.shareContent = shareContent;
        }

        public TopCommentBean getTopComment() {
            return topComment;
        }

        public void setTopComment(TopCommentBean topComment) {
            this.topComment = topComment;
        }

        public String getContinuedPercent() {
            return continuedPercent;
        }

        public void setContinuedPercent(String continuedPercent) {
            this.continuedPercent = continuedPercent;
        }

        public String getTimelyPercent() {
            return timelyPercent;
        }

        public void setTimelyPercent(String timelyPercent) {
            this.timelyPercent = timelyPercent;
        }

        public String getGiftNum() {
            return giftNum;
        }

        public void setGiftNum(String giftNum) {
            this.giftNum = giftNum;
        }

        public List<CatgsRatingBean> getCatgsRating() {
            return catgsRating;
        }

        public void setCatgsRating(List<CatgsRatingBean> catgsRating) {
            this.catgsRating = catgsRating;
        }

        public static class TopCommentBean {
            /**
             * id : 64699
             * objectId : 54442
             * objectType : consultant
             * userid : 89343
             * name : 婷**
             * avatar : http://icon.xinliji.me//avatar_0_63.png
             * replyToUserid :
             * replyToUserName :
             * replyToContent :
             * content : 医生很好，我很喜欢她呦☺️
             * createdDate : 1470893139
             * consultantTags : 自卑
             * rating : 5
             */

            private String id;
            private String objectId;
            private String objectType;
            private String userid;
            private String name;
            private String avatar;
            private String replyToUserid;
            private String replyToUserName;
            private String replyToContent;
            private String content;
            private String consultantTags;
            private String rating;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getObjectId() {
                return objectId;
            }

            public void setObjectId(String objectId) {
                this.objectId = objectId;
            }

            public String getObjectType() {
                return objectType;
            }

            public void setObjectType(String objectType) {
                this.objectType = objectType;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getReplyToUserid() {
                return replyToUserid;
            }

            public void setReplyToUserid(String replyToUserid) {
                this.replyToUserid = replyToUserid;
            }

            public String getReplyToUserName() {
                return replyToUserName;
            }

            public void setReplyToUserName(String replyToUserName) {
                this.replyToUserName = replyToUserName;
            }

            public String getReplyToContent() {
                return replyToContent;
            }

            public void setReplyToContent(String replyToContent) {
                this.replyToContent = replyToContent;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getConsultantTags() {
                return consultantTags;
            }

            public void setConsultantTags(String consultantTags) {
                this.consultantTags = consultantTags;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }
        }

        public static class CatgsRatingBean {
            /**
             * key : BAOZAO
             * label : 暴躁
             * rating : 12
             */

            private String key;
            private String label;
            private String rating;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }
        }
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "errorCode='" + errorCode + '\'' +
                ", errorStr='" + errorStr + '\'' +
                ", resultCount='" + resultCount + '\'' +
                ", score='" + score + '\'' +
                ", balance='" + balance + '\'' +
                ", results=" + results.getAvatar() +
                '}';
    }
}
