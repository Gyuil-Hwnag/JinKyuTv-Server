package com.example.demo.src.video;

import com.example.demo.src.video.model.request.PatchVideoReq;
import com.example.demo.src.video.model.request.PostVideoReq;
import com.example.demo.src.video.model.response.GetVideoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class VideoDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetVideoRes> getVideos() {
        String getVideosQuery = "select * from VideoInfo";
        return this.jdbcTemplate.query(getVideosQuery,
                (rs, rowNum) -> new GetVideoRes(
                        rs.getInt("videoIdx"),
                        rs.getString("videoName"),
                        rs.getString("videoUrl"),
                        rs.getString("videoThumbnail")
                )
        );
    }

    public List<GetVideoRes> getVideosByName(String videoName) {
        String getVideosByNameQuery = "select * from VideoInfo where videoName =?";
        String getVideosByNamelParams = videoName;
        return this.jdbcTemplate.query(getVideosByNameQuery,
                (rs, rowNum) -> new GetVideoRes(
                        rs.getInt("videoIdx"),
                        rs.getString("videoName"),
                        rs.getString("videoUrl"),
                        rs.getString("videoThumbnail")
                ),
                getVideosByNamelParams);
    }

    public GetVideoRes getVideo(int videoIdx) {
        String getVideoQuery = "select * from VideoInfo where videoIdx = ?";
        int getVideoParams = videoIdx;
        return this.jdbcTemplate.queryForObject(getVideoQuery,
                (rs, rowNum) -> new GetVideoRes(
                        rs.getInt("videoIdx"),
                        rs.getString("videoName"),
                        rs.getString("videoUrl"),
                        rs.getString("videoThumbnail")
                ),
                getVideoParams);
    }


    public int createVideo(PostVideoReq postVideoReq) {
        String createVideoQuery = "insert into VideoInfo (videoName, videoUrl, videoThumbnail) VALUES (?,?,?)";
        Object[] createVideoParams = new Object[]{postVideoReq.getVideoName(), postVideoReq.getVideoUrl(), postVideoReq.getVideoThumbnail()};
        this.jdbcTemplate.update(createVideoQuery, createVideoParams);

        String lastInserIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInserIdQuery, int.class);
    }

    public int modifyVideoName(PatchVideoReq patchVideoReq) {
        String modifyVideoNameQuery = "update VideoInfo set videoName = ? where videoIdx = ? ";
        Object[] modifyVideoNameParams = new Object[]{patchVideoReq.getVideoName(), patchVideoReq.getVideoIdx()};

        return this.jdbcTemplate.update(modifyVideoNameQuery, modifyVideoNameParams);
    }

    public int modifyVideoUrl(PatchVideoReq patchVideoReq) {
        String modifyVideoUrlQuery = "update VideoInfo set videoUrl = ? where videoIdx = ? ";
        Object[] modifyVideoUrlParams = new Object[]{patchVideoReq.getVideoUrl(), patchVideoReq.getVideoIdx()};

        return this.jdbcTemplate.update(modifyVideoUrlQuery, modifyVideoUrlParams);
    }

    public int modifyVideoThumbnail(PatchVideoReq patchVideoReq) {
        String modifyVideoThumbnailQuery = "update VideoInfo set videoThumbnail = ? where videoIdx = ? ";
        Object[] modifyVideoThumbnailParams = new Object[]{patchVideoReq.getVideoThumbnail(), patchVideoReq.getVideoIdx()};

        return this.jdbcTemplate.update(modifyVideoThumbnailQuery, modifyVideoThumbnailParams);
    }
}
