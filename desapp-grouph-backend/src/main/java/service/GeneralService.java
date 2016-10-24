
package service;

public class GeneralService {

	private UserService userService;
	private ProfileService profileService;
	private EventService eventService;


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
}
