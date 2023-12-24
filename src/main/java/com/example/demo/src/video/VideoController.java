package com.example.demo.src.video;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.video.model.Video;
import com.example.demo.src.video.model.request.PatchVideoReq;
import com.example.demo.src.video.model.request.PostVideoReq;
import com.example.demo.src.video.model.response.GetVideoRes;
import com.example.demo.src.video.model.response.PostVideoRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.POST_USERS_EMPTY_URL;
import static com.example.demo.config.BaseResponseStatus.POST_VIDEO_EMPTY_NAME;

@RestController
@RequestMapping("/app/videos")
public class VideoController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final VideoProvider videoProvider;
    @Autowired
    private final VideoService videoService;


    public VideoController(VideoProvider videoProvider, VideoService videoService) {
        this.videoProvider = videoProvider;
        this.videoService = videoService;
    }

    /**
     * Video 리스트 조회 API
     * [GET] /videos
     *
     * @return BaseResponse<List<GetVideoRes>>
     */
    //Query String
    @ResponseBody
    @GetMapping("") // (GET) 127.0.0.1:9000/app/videos
    public BaseResponse<List<GetVideoRes>> getUsers(@RequestParam(required = false) String videoName) {
        try {
            if (videoName == null) {
                List<GetVideoRes> getUsersRes = videoProvider.getVideos();
                return new BaseResponse<>(getUsersRes);
            }
            // Get Users
            List<GetVideoRes> getUsersRes = videoProvider.getVideoByName(videoName);
            return new BaseResponse<>(getUsersRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * Video 1개 조회 API
     * [GET] /users/:userIdx
     *
     * @return BaseResponse<GetVideoRes>
     */
    // Path-variable
    @ResponseBody
    @GetMapping("/{videoIdx}") // (GET) 127.0.0.1:9000/app/videos/:videoIdx
    public BaseResponse<GetVideoRes> getUser(@PathVariable("videoIdx") int videoIdx) {
        // Get Users
        try {
            GetVideoRes getVideoRes = videoProvider.getVideo(videoIdx);
            return new BaseResponse<>(getVideoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * Video 생성 API
     * [POST] /videos
     *
     * @return BaseResponse<PostUserRes>
     */
    // Body
    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostVideoRes> createVideo(@RequestBody PostVideoReq postVideoReq) {
        if (postVideoReq.getVideoName() == null) {
            return new BaseResponse<>(POST_VIDEO_EMPTY_NAME);
        }
        if (postVideoReq.getVideoUrl() == null) {
            return new BaseResponse<>(POST_USERS_EMPTY_URL);
        }
        try {
            PostVideoRes postVideoRes = videoService.createVideo(postVideoReq);
            return new BaseResponse<>(postVideoRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 비디오 정보 변경 API
     * [PATCH] /videos/:videoIdx
     *
     * @return BaseResponse<String>
     */
    @ResponseBody
    @PatchMapping("/{videoIdx}")
    public BaseResponse<String> modifyUserName(@PathVariable("videoIdx") int videoIdx, @RequestBody Video video) {
        try {
            PatchVideoReq patchVideoReq = new PatchVideoReq(videoIdx, video.getVideoName(), video.getVideoUrl());
            videoService.modifyVideo(patchVideoReq);

            String result = "";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
