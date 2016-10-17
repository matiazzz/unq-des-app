
package service;

public class GeneralService {

	private UserService userService;
	private ProfileService profileService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
	}

}
