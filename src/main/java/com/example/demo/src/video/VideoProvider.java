package com.example.demo.src.video;


import com.example.demo.config.BaseException;
import com.example.demo.src.video.model.response.GetVideoRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

//Provider : Read의 비즈니스 로직 처리
@Service
public class VideoProvider {

    private final VideoDao videoDao;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public VideoProvider(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    public List<GetVideoRes> getVideos() throws BaseException {
        try {
            List<GetVideoRes> getVideoRes = videoDao.getVideos();
            return getVideoRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<GetVideoRes> getVideoByName(String videoName) throws BaseException {
        try {
            List<GetVideoRes> getVideoRes = videoDao.getVideosByName(videoName);
            return getVideoRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


    public GetVideoRes getVideo(int videoIdx) throws BaseException {
        try {
            GetVideoRes getVideoRes = videoDao.getVideo(videoIdx);
            return getVideoRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
