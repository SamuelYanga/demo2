package com.samuel.bdd.base.wait;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.util.List;

public class MyElementLocator implements ElementLocator {
  private final static Logger LOGGER = Logger.getLogger(MyElementLocator.class);

  private final SearchContext searchContext;
  private final boolean shouldCache;
  private final By by;
  private WebElement cachedElement;
  private List<WebElement> cachedElementList;

  /**
   * Creates a new element locator.
   *
   * @param searchContext The context to use when finding the element
   * @param field The field on the Page Object that will hold the located value
   */
  public MyElementLocator(SearchContext searchContext, Field field) {
    this(searchContext, new Annotations(field));
  }

  /**
   * Use this constructor in order to process custom annotaions.
   *
   * @param searchContext The context to use when finding the element
   * @param annotations AbstractAnnotations class implementation
   */
  public MyElementLocator(SearchContext searchContext, AbstractAnnotations annotations) {
    this.searchContext = searchContext;
    this.shouldCache = annotations.isLookupCached();
    this.by = annotations.buildBy();
  }

  /**
   * Find the element.
   */
  public WebElement findElement() {
    if (cachedElement != null && shouldCache) {
      return cachedElement;
    }

    WebElement element = WaitUtil.waitOn(this.searchContext).untilAdded(by);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("element has been waitted");
    }
    if (shouldCache) {
      cachedElement = element;
    }

    return element;
  }

  /**
   * Find the element list.
   */
  public List<WebElement> findElements() {
    if (cachedElementList != null && shouldCache) {
      return cachedElementList;
    }

    List<WebElement> elements = WaitUtil.waitOn(this.searchContext).untilCountGe(by, 1);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("element has been waitted");
    }
    if (shouldCache) {
      cachedElementList = elements;
    }

    return elements;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " '" + by + "'";
  }
}
