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
 * Describes some place
 */
public class Place extends BaseRDF {

    private static final String CLASS_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#Place";
    private static final String NOTIFICATION_URI = "http://oss.fruct.org/smartjavalog#org.fruct.oss.geopoint/Place/Notification";

    private static boolean classLoader = classLoader();

    private static boolean classLoader() {
        BaseRDF.registerInstance(CLASS_URI, NOTIFICATION_URI, new BaseRDFChildInstance() {
            @Override
            public BaseRDF getInstance(String objectId) {
                return Place.getInstance(objectId, SIBFactory.getInstance().getDefaultAccessPointName());
            }

            @Override
            public BaseRDF getInstance() {
                return Place.getInstance();
            }
        });

        return true;
    }

    public static Place getInstance(String objectId, String accessPointName) {
        Place ret = (Place) SubscribeQuery.getInstance().getKnownObject(objectId);

        if (ret == null) {
            ret = new Place(objectId, accessPointName);
            SubscribeQuery.getInstance().registerObject(ret);
        }

        return ret;
    }

    public static Place getInstance() {
        Place ret = new Place();
        SubscribeQuery.getInstance().registerObject(ret);

        return ret;
    }

    /**
     * Creates new class entity
     * @param objectID class entity id
     * @param accessPointName the name of used access point
     */
    protected Place(String objectID, String accessPointName) {
        super(objectID, accessPointName);
    }

    /**
     * Creates new class entity
     * @param accessPointName  the name of used access point
     */
    protected Place(String accessPointName) {
        super(generateID("Place"), accessPointName);
        isNew = true;
    }

    protected Place() {
        super(generateID("Place"), SIBFactory.getInstance().getDefaultAccessPointName());
        isNew = true;
    }

    /**
     * Return class URI from ontology model
     * @return String with class URI
     */
    public static String getClassUri() { return CLASS_URI; }

    //------------ IsWest --------------
    private static final String IsWest_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#isWest";
    private List<String> _IsWest_new = null;

    public List<String> getIsWest() {
        if (_IsWest_new != null) {
            return _IsWest_new;
        }
        // search in triple store
        return getInTriples(IsWest_URI);
    }

    public <T> void setIsWest(List<T> value) {
        setIsWest(value, true);
    }

    public <T> void setIsWest(List<T> value, boolean removeOldValues) {
        if (_IsWest_new == null) {
            _IsWest_new = getIsWest();
        }
        if (removeOldValues) {
            _IsWest_new.clear();
        }
        for (T item : value)
            _IsWest_new.add(item.toString());
    }

            public void setIsWest(Boolean value) {
                setIsWest(value, true);
            }

            public void setIsWest(Boolean value, boolean removeOldValues) {
                if (_IsWest_new == null) {
                    _IsWest_new = getIsWest();
                }
                if (removeOldValues) {
                    _IsWest_new.clear();
                }
                _IsWest_new.add(value.toString());
            }

            public void setIsWest(Integer value) {
                setIsWest(value, true);
            }

            public void setIsWest(Integer value, boolean removeOldValues) {
                if (_IsWest_new == null) {
                    _IsWest_new = getIsWest();
                }
                if (removeOldValues) {
                    _IsWest_new.clear();
                }
                _IsWest_new.add(value.toString());
            }


    //============== IsWest =============
    //------------ Name --------------
    private static final String Name_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#name";
    private List<String> _Name_new = null;

    public List<String> getName() {
        if (_Name_new != null) {
            return _Name_new;
        }
        // search in triple store
        return getInTriples(Name_URI);
    }

    public <T> void setName(List<T> value) {
        setName(value, true);
    }

    public <T> void setName(List<T> value, boolean removeOldValues) {
        if (_Name_new == null) {
            _Name_new = getName();
        }
        if (removeOldValues) {
            _Name_new.clear();
        }
        for (T item : value)
            _Name_new.add(item.toString());
    }

            public void setName(String value) {
                setName(value, true);
            }

            public void setName(String value, boolean removeOldValues) {
                if (_Name_new == null) {
                    _Name_new = getName();
                }
                if (removeOldValues) {
                    _Name_new.clear();
                }
                _Name_new.add(value.toString());
            }


    //============== Name =============
    //------------ IsNorth --------------
    private static final String IsNorth_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#isNorth";
    private List<String> _IsNorth_new = null;

    public List<String> getIsNorth() {
        if (_IsNorth_new != null) {
            return _IsNorth_new;
        }
        // search in triple store
        return getInTriples(IsNorth_URI);
    }

    public <T> void setIsNorth(List<T> value) {
        setIsNorth(value, true);
    }

    public <T> void setIsNorth(List<T> value, boolean removeOldValues) {
        if (_IsNorth_new == null) {
            _IsNorth_new = getIsNorth();
        }
        if (removeOldValues) {
            _IsNorth_new.clear();
        }
        for (T item : value)
            _IsNorth_new.add(item.toString());
    }

            public void setIsNorth(Boolean value) {
                setIsNorth(value, true);
            }

            public void setIsNorth(Boolean value, boolean removeOldValues) {
                if (_IsNorth_new == null) {
                    _IsNorth_new = getIsNorth();
                }
                if (removeOldValues) {
                    _IsNorth_new.clear();
                }
                _IsNorth_new.add(value.toString());
            }

            public void setIsNorth(Integer value) {
                setIsNorth(value, true);
            }

            public void setIsNorth(Integer value, boolean removeOldValues) {
                if (_IsNorth_new == null) {
                    _IsNorth_new = getIsNorth();
                }
                if (removeOldValues) {
                    _IsNorth_new.clear();
                }
                _IsNorth_new.add(value.toString());
            }


    //============== IsNorth =============
    //------------ HasPoint --------------
        private static final String HasPoint_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#hasPoint";
        private ArrayList<Point> _HasPoint_new = null;


        public ArrayList<Point> getHasPoint() {
            if (_HasPoint_new != null)
                return _HasPoint_new;

            ArrayList<Point> ret = new ArrayList();
            //search IDs in triples
            ArrayList<String> HasPointIDs = getInTriples(HasPoint_URI);
            for (String locID: HasPointIDs) {
                Point value = Point.getInstance(locID, _accessPointName);
                ret.add(value);
            }

            return ret;
        }

        public void setHasPoint(Point loc) {
            setHasPoint(loc, true);
        }

        public void setHasPoint(Point value, boolean removeOldValues) {
            if (_HasPoint_new == null) {
                _HasPoint_new = getHasPoint();
            }
            if (removeOldValues) {
                _HasPoint_new.clear();
            }
            _HasPoint_new.add(value);
        }
    //============== HasPoint =============


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

                        if (_IsWest_new != null) {
                            // получаем старые значения
                            ArrayList<String> oldVals = getInTriples(IsWest_URI);
                            Iterator<String> itrNew = _IsWest_new.iterator();
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
                            for(String val : _IsWest_new) {
                                newTriples.add(createTriple(getID(), IsWest_URI, val, "uri", "literal"));
                            }
                            for(String val : oldVals){
                                removeTriples.add(createTriple(getID(), IsWest_URI, val, "uri", "literal"));
                            }
                	    _IsWest_new = null;
                        }
                //-----------------------
                        if (_Name_new != null) {
                            // получаем старые значения
                            ArrayList<String> oldVals = getInTriples(Name_URI);
                            Iterator<String> itrNew = _Name_new.iterator();
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
                            for(String val : _Name_new) {
                                newTriples.add(createTriple(getID(), Name_URI, val, "uri", "literal"));
                            }
                            for(String val : oldVals){
                                removeTriples.add(createTriple(getID(), Name_URI, val, "uri", "literal"));
                            }
                	    _Name_new = null;
                        }
                //-----------------------
                        if (_IsNorth_new != null) {
                            // получаем старые значения
                            ArrayList<String> oldVals = getInTriples(IsNorth_URI);
                            Iterator<String> itrNew = _IsNorth_new.iterator();
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
                            for(String val : _IsNorth_new) {
                                newTriples.add(createTriple(getID(), IsNorth_URI, val, "uri", "literal"));
                            }
                            for(String val : oldVals){
                                removeTriples.add(createTriple(getID(), IsNorth_URI, val, "uri", "literal"));
                            }
                	    _IsNorth_new = null;
                        }
                //-----------------------
                        if (_HasPoint_new != null) {
                            // получаем старые значения
                            ArrayList<String> oldValsIDs = getInTriples(HasPoint_URI);
                            Iterator<Point> itrNew = _HasPoint_new.iterator();
                            while (itrNew.hasNext()) {
                                Point curNew = itrNew.next();
                                // ищем старое значение
                                Iterator<String> itrOldID = oldValsIDs.iterator();
                                while(itrOldID.hasNext()) {
                                    String curOldID = itrOldID.next();
                                    if (curNew.getID().equals(curOldID)) {
                                        itrNew.remove();
                                        itrOldID.remove();
                                        break;
                                    }
                                }
                            }
                            _HasPoint_new.stream().forEach((Point val) -> {
                                newTriples.add(createTriple(getID(), HasPoint_URI, val.getID(), "uri", "literal"));
                            });
                            oldValsIDs.stream().forEach((val) -> {
                                removeTriples.add(createTriple(getID(), HasPoint_URI, val, "uri", "literal"));
                            });
                	    _HasPoint_new = null;
                        }
                //--------------------


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