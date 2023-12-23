package com.example.demo.src.video;


import com.example.demo.config.BaseException;
import com.example.demo.src.video.model.request.PatchVideoReq;
import com.example.demo.src.video.model.request.PostVideoReq;
import com.example.demo.src.video.model.response.PostVideoRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

// Service Create, Update, Delete 의 로직 처리
@Service
public class VideoService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final VideoDao videoDao;
    private final VideoProvider videoProvider;

    @Autowired
    public VideoService(VideoDao videoDao, VideoProvider videoProvider) {
        this.videoDao = videoDao;
        this.videoProvider = videoProvider;
    }

    //POST
    public PostVideoRes createVideo(PostVideoReq postVideoReq) throws BaseException {
        try {
            int videoIdx = videoDao.createVideo(postVideoReq);
            return new PostVideoRes(videoIdx);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void modifyVideo(PatchVideoReq patchVideoReq) throws BaseException {
        try {
            int resultName = videoDao.modifyVideoName(patchVideoReq);
            int resultUrl = videoDao.modifyVideoUrl(patchVideoReq);
            if (resultName == 0 || resultUrl == 0) {
                throw new BaseException(MODIFY_FAIL_USERNAME);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
