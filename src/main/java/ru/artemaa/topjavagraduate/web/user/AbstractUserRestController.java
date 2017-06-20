package ru.artemaa.topjavagraduate.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.artemaa.topjavagraduate.model.User;
import ru.artemaa.topjavagraduate.service.UserService;

import java.util.List;

import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkIdConsistent;
import static ru.artemaa.topjavagraduate.util.ValidationUtil.checkNew;


public abstract class AbstractUserRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    //public static final String EXCEPTION_DUPLICATE_EMAIL = "exception.user.duplicateEmail";
    //public static final String EXCEPTION_MODIFICATION_RESTRICTION = "exception.user.modificationRestriction";

    private final UserService service;

    //@Autowired
    //private ExceptionInfoHandler exceptionInfoHandler;

    //private boolean modificationRestriction;

    /*@Autowired
    public void setEnvironment(Environment environment) {
        modificationRestriction = environment.acceptsProfiles(Profiles.HEROKU);
    }*/

    public AbstractUserRestController(UserService service) {
        this.service = service;
    }

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.save(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        //checkModificationAllowed(id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        checkIdConsistent(user, id);
        //checkModificationAllowed(id);
        service.update(user);
    }

    /*public void update(UserTo userTo, int id) {
        log.info("update {} with id={}", userTo, id);
        checkIdConsistent(userTo, id);
        checkModificationAllowed(id);
        service.update(userTo);
    }*/

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }

    /*public void enable(int id, boolean enabled) {
        log.info((enabled ? "enable " : "disable ") + id);
        checkModificationAllowed(id);
        service.enable(id, enabled);
    }*/

    /*public void checkModificationAllowed(int id) {
        if (modificationRestriction && id < BaseEntity.START_SEQ + 2) {
            throw new ApplicationException(EXCEPTION_MODIFICATION_RESTRICTION, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
        }
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorInfo> duplicateEmailException(HttpServletRequest req, DataIntegrityViolationException e) {
        return exceptionInfoHandler.getErrorInfoResponseEntity(req, e, EXCEPTION_DUPLICATE_EMAIL, HttpStatus.CONFLICT);
    }*/
}