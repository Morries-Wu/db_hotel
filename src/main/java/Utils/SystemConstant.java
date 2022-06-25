package Utils;

public interface SystemConstant {
    /**
     * 加密次数
     */
    Integer PASSWORD_COUNT = 5;

    /**
     * 后台用户登录用户保存的key
     */
    String LOGINUSER = "loginUser";

    /**
     * 成功
     */
    String SUCCESS = "success";

    /**
     * 验证提示信息
     */
    String MESSAGE = "message";

    /**
     * 是否存在
     */
    String EXIST = "exist";

    /**
     * 默认密码
     */
    String DEFAULT_LOGIN_PWD ="123456" ;

    /**
     * 图片上传的地址
     */
    String IMAGE_UPLOAD_PATH="F:/Multifunctionapplication/Advanced Files/IntelliJ IDEA Project/SSM/db_hotel/UploadImg/";

    /**
     * 前台用户登录时保存key
     */
    String FRONT_LOGIN_USER = "currentUser";
}
