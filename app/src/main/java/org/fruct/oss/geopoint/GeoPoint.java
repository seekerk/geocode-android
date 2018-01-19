package org.fruct.oss.geopoint;

import org.fruct.oss.geopoint.base.BaseRDF;
import org.fruct.oss.geopoint.base.SIBFactory;
import org.fruct.oss.geopoint.base.TaskListener;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import sofia_kp.KPICore;
import sofia_kp.SIBResponse;

/**
 * null
 */
public class GeoPoint extends BaseRDF {

    private static final String CLASS_URI = "http://www.semanticweb.org/kulakov/ontologies/2018/0/untitled-ontology-2#GeoPoint";

    /**
     * Creates new class entity
     * @param objectID class entity id
     * @param accessPointName the name of used access point
     */
    public GeoPoint(String objectID, String accessPointName) {
        super(objectID, accessPointName);
    }

    /**
     * Creates new class entity
     * @param accessPointName  the name of used access point
     */
    public GeoPoint(String accessPointName) {
        super(generateID("GeoPoint"), accessPointName);
    }

    public GeoPoint() {
        super(generateID("GeoPoint"), SIBFactory.getInstance().getDefaultAccessPointName());
    }

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
        load().addListener(new TaskListener() {
            @Override
            public void onSuccess(SIBResponse response) {

                // триплеты для добавления
                ArrayList<ArrayList<String>> newTriples = new ArrayList();

                // триплеты для удаления
                ArrayList<ArrayList<String>> removeTriples = new ArrayList();

                // 1. проверяем, новый ли индивид. Если новый, то у него нет триплетов с сиба
                if (getInTriples(RDF_TYPE_URI).isEmpty()) {
                    // Добавляем триплет для класса индивида
                    newTriples.add(createTriple(getID(), RDF_TYPE_URI, getURI()));
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


                SIBFactory.getInstance().getAccessPoint(_accessPointName).insert(newTriples).addListener(new TaskListener() {
                    @Override
                    public void onSuccess(SIBResponse response) {
                        if (!response.isConfirmed()) {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        SIBFactory.getInstance().getAccessPoint(_accessPointName).remove(removeTriples).addListener(new TaskListener() {
                            @Override
                            public void onSuccess(SIBResponse response) {
                                if (!response.isConfirmed()) {
                                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                }
                                task.setSuccess(response);
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
            }

            @Override
            public void onError(Exception ex) {
                task.setError(ex);
            }
        });

        return task;
    }

    @Override
    public String getURI() {
        return CLASS_URI;
    }

    @Override
    public void removeProperty(String URI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}