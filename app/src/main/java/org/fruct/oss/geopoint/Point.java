package org.fruct.oss.geopoint;

import org.fruct.oss.smartjavalog.base.BaseRDF;
import org.fruct.oss.smartjavalog.base.SIBFactory;
import org.fruct.oss.smartjavalog.base.SubscribeQuery;
import org.fruct.oss.smartjavalog.base.TaskListener;

import java.util.*;

import sofia_kp.SIBResponse;

import static org.fruct.oss.smartjavalog.base.KPIproxy.NOTIFICATION_INDIVIDE;
import static org.fruct.oss.smartjavalog.base.KPIproxy.NOTIFICATION_UPDATE_TIME;
import static org.fruct.oss.smartjavalog.base.KPIproxy.RDF_TYPE_URI;

/**
 * null
 */
public class Point extends BaseRDF {

    private static final String CLASS_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#Point";
    private static final String NOTIFICATION_URI = "http://oss.fruct.org/smartjavalog#org.fruct.oss.geopoint/Point/Notification";

    private static boolean classLoader = classLoader();

    private static boolean classLoader() {
        BaseRDF.registerInstance(CLASS_URI, NOTIFICATION_URI, new BaseRDFChildInstance() {
            @Override
            public BaseRDF getInstance(String objectId) {
                return Point.getInstance(objectId, SIBFactory.getInstance().getDefaultAccessPointName());
            }

            @Override
            public BaseRDF getInstance() {
                return Point.getInstance();
            }
        });

        return true;
    }

    public static Point getInstance(String objectId, String accessPointName) {
        Point ret = (Point) SubscribeQuery.getInstance().getKnownObject(objectId);

        if (ret == null) {
            ret = new Point(objectId, accessPointName);
            SubscribeQuery.getInstance().registerObject(ret);
        }

        return ret;
    }

    public static Point getInstance() {
        Point ret = new Point();
        SubscribeQuery.getInstance().registerObject(ret);

        return ret;
    }

    /**
     * Creates new class entity
     * @param objectID class entity id
     * @param accessPointName the name of used access point
     */
    protected Point(String objectID, String accessPointName) {
        super(objectID, accessPointName);
    }

    /**
     * Creates new class entity
     * @param accessPointName  the name of used access point
     */
    protected Point(String accessPointName) {
        super(generateID("Point"), accessPointName);
        isNew = true;
    }

    protected Point() {
        super(generateID("Point"), SIBFactory.getInstance().getDefaultAccessPointName());
        isNew = true;
    }

    /**
     * Return class URI from ontology model
     * @return String with class URI
     */
    public static String getClassUri() { return CLASS_URI; }

    //------------ HasLongitude --------------
    private static final String HasLongitude_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#hasLongitude";
    private List<String> _HasLongitude_new = null;

    public List<String> getHasLongitude() {
        if (_HasLongitude_new != null) {
            return _HasLongitude_new;
        }
        // search in triple store
        return getInTriples(HasLongitude_URI);
    }

    public <T> void setHasLongitude(List<T> value) {
        setHasLongitude(value, true);
    }

    public <T> void setHasLongitude(List<T> value, boolean removeOldValues) {
        if (_HasLongitude_new == null) {
            _HasLongitude_new = getHasLongitude();
        }
        if (removeOldValues) {
            _HasLongitude_new.clear();
        }
        for (T item : value)
            _HasLongitude_new.add(item.toString());
    }

            public void setHasLongitude(Double value) {
                setHasLongitude(value, true);
            }

            public void setHasLongitude(Double value, boolean removeOldValues) {
                if (_HasLongitude_new == null) {
                    _HasLongitude_new = getHasLongitude();
                }
                if (removeOldValues) {
                    _HasLongitude_new.clear();
                }
                _HasLongitude_new.add(value.toString());
            }


    //============== HasLongitude =============
    //------------ HasLatitude --------------
    private static final String HasLatitude_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#hasLatitude";
    private List<String> _HasLatitude_new = null;

    public List<String> getHasLatitude() {
        if (_HasLatitude_new != null) {
            return _HasLatitude_new;
        }
        // search in triple store
        return getInTriples(HasLatitude_URI);
    }

    public <T> void setHasLatitude(List<T> value) {
        setHasLatitude(value, true);
    }

    public <T> void setHasLatitude(List<T> value, boolean removeOldValues) {
        if (_HasLatitude_new == null) {
            _HasLatitude_new = getHasLatitude();
        }
        if (removeOldValues) {
            _HasLatitude_new.clear();
        }
        for (T item : value)
            _HasLatitude_new.add(item.toString());
    }

            public void setHasLatitude(Double value) {
                setHasLatitude(value, true);
            }

            public void setHasLatitude(Double value, boolean removeOldValues) {
                if (_HasLatitude_new == null) {
                    _HasLatitude_new = getHasLatitude();
                }
                if (removeOldValues) {
                    _HasLatitude_new.clear();
                }
                _HasLatitude_new.add(value.toString());
            }


    //============== HasLatitude =============


    public InteractionSIBTask update() {
        final InteractionSIBTask task = new InteractionSIBTask();
        // update triple store
        download(false).addListener(new TaskListener() {
            @Override
            public void onSuccess(SIBResponse response) {

                // триплеты для добавления
                ArrayList<ArrayList<String>> newTriples = new ArrayList<>();

                // триплеты для удаления
                ArrayList<ArrayList<String>> removeTriples = new ArrayList<>();

                String notificationId = null;

                // 1. проверяем, новый ли индивид. Если новый, то у него нет триплетов с сиба
                if (isNew) {
                    // Добавляем триплет для класса индивида
                    newTriples.add(createTriple(getID(), RDF_TYPE_URI, getClassUri()));
                }

                        if (_HasLongitude_new != null) {
                            // получаем старые значения
                            ArrayList<String> oldVals = getInTriples(HasLongitude_URI);
                            Iterator<String> itrNew = _HasLongitude_new.iterator();
                            while (itrNew.hasNext()) {
                                String curNew = itrNew.next();
                                // ищем старое значение
                                Iterator<String> itrOld = oldVals.iterator();
                                while(itrOld.hasNext()) {
                                    String curOld = itrOld.next();
                                    if (curNew.equals(curOld)) {
                                        itrNew.remove();
                                        itrOld.remove();
                                        break;
                                    }
                                }
                            }
                            for(String val : _HasLongitude_new) {
                                newTriples.add(createTriple(getID(), HasLongitude_URI, val, "uri", "literal"));
                            }
                            for(String val : oldVals){
                                removeTriples.add(createTriple(getID(), HasLongitude_URI, val, "uri", "literal"));
                            }
                	    _HasLongitude_new = null;
                        }
                //-----------------------
                        if (_HasLatitude_new != null) {
                            // получаем старые значения
                            ArrayList<String> oldVals = getInTriples(HasLatitude_URI);
                            Iterator<String> itrNew = _HasLatitude_new.iterator();
                            while (itrNew.hasNext()) {
                                String curNew = itrNew.next();
                                // ищем старое значение
                                Iterator<String> itrOld = oldVals.iterator();
                                while(itrOld.hasNext()) {
                                    String curOld = itrOld.next();
                                    if (curNew.equals(curOld)) {
                                        itrNew.remove();
                                        itrOld.remove();
                                        break;
                                    }
                                }
                            }
                            for(String val : _HasLatitude_new) {
                                newTriples.add(createTriple(getID(), HasLatitude_URI, val, "uri", "literal"));
                            }
                            for(String val : oldVals){
                                removeTriples.add(createTriple(getID(), HasLatitude_URI, val, "uri", "literal"));
                            }
                	    _HasLatitude_new = null;
                        }
                //-----------------------


                if (!isNew && (newTriples.size() > 0 || removeTriples.size() > 0)) {
                    notificationId = generateID("notification");
                    newTriples.add(BaseRDF.createTriple(notificationId, RDF_TYPE_URI, NOTIFICATION_URI));
                    newTriples.add(BaseRDF.createTriple(notificationId, NOTIFICATION_INDIVIDE, getID()));
                    newTriples.add(BaseRDF.createTriple(notificationId, NOTIFICATION_UPDATE_TIME, System.currentTimeMillis() / 1000L));
                    SubscribeQuery.getInstance().registerNotification(notificationId);
                }

                String finalNotificationId = notificationId;

                SIBFactory.getInstance().getAccessPoint(_accessPointName).insert(newTriples).addListener(new TaskListener() {
                    @Override
                    public void onSuccess(SIBResponse response) {
                        if (!response.isConfirmed()) {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        if (removeTriples.size() > 0) {
                            SIBFactory.getInstance().getAccessPoint(_accessPointName).remove(removeTriples).addListener(new TaskListener() {
                                @Override
                                public void onSuccess(SIBResponse response) {
                                    if (!response.isConfirmed()) {
                                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                    }
                                    task.setSuccess(response);
                                    isNew = false;
                                    if (finalNotificationId != null) {
                                        new Timer().schedule(new TimerTask() {
                                            @Override
                                            public void run() {
                                                SIBFactory.getInstance().getAccessPoint(_accessPointName).removeInstance(finalNotificationId);
                                                SubscribeQuery.getInstance().removeNotificationRegistration(finalNotificationId);
                                            }
                                        }, NOTIFICATION_TIMEOUT);
                                    }
                                }

                                @Override
                                public void onError(Exception ex) {
                                    task.setError(ex);
                                }
                            });
                        } else {
                            task.setSuccess(response);
                            isNew = false;
                            if (finalNotificationId != null) {
                                new Timer().schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        SIBFactory.getInstance().getAccessPoint(_accessPointName).removeInstance(finalNotificationId);
                                        SubscribeQuery.getInstance().removeNotificationRegistration(finalNotificationId);
                                    }
                                }, NOTIFICATION_TIMEOUT);
                            }
                        }
                    }

                    @Override
                    public void onError(Exception ex) {
                        task.setError(ex);
                    }
                });
            }

            @Override
            public void onError(Exception ex) {
                task.setError(ex);
            }
        });

        return task;
    }

    @Override
    public void removeProperty(String URI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}