/*******************************************************************************
 * Copyright (c) 2019, 2019 IBM Corporation and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.kruize.recommendations.application;

import com.kruize.exceptions.NoSuchApplicationException;
import com.kruize.metrics.PodMetrics;

import java.util.HashMap;

public class KubernetesApplicationRecommendations extends AbstractApplicationRecommendations<PodMetrics>
{
    public KubernetesApplicationRecommendations()
    {
        applicationMap = new HashMap<>();
    }

    @SuppressWarnings("unused")
    public double getCpuRequests(String applicationName) throws NoSuchApplicationException
    {
        if(applicationMap.containsKey(applicationName))
        {
            double weightedCpuRequests = 0;
            double totalValues = 0;

            for(PodMetrics podMetrics : applicationMap.get(applicationName))
            {
                int numberOfValues = podMetrics.metricCollector.size();
                weightedCpuRequests += podMetrics.getCpuRequests() * numberOfValues;

                totalValues += numberOfValues;
            }

            return weightedCpuRequests / totalValues;

        }
        else
        {
            throw new NoSuchApplicationException();
        }
    }

    @SuppressWarnings("unused")
    public double getCpuLimit(String applicationName) throws NoSuchApplicationException
    {
        if(applicationMap.containsKey(applicationName))
        {
            double weightedCpuRequests = 0;
            double totalValues = 0;

            for(PodMetrics podMetrics : applicationMap.get(applicationName))
            {
                int numberOfValues = podMetrics.metricCollector.size();
                weightedCpuRequests += podMetrics.getCpuLimit() * numberOfValues;

                totalValues += numberOfValues;
            }

            return weightedCpuRequests / totalValues;

        }
        else
        {
            throw new NoSuchApplicationException();
        }
    }

    @SuppressWarnings("unused")
    public double getRssRequests(String applicationName) throws NoSuchApplicationException
    {
        if(applicationMap.containsKey(applicationName))
        {
            double weightedCpuRequests = 0;
            double totalValues = 0;

            for(PodMetrics podMetrics : applicationMap.get(applicationName))
            {
                int numberOfValues = podMetrics.metricCollector.size();
                weightedCpuRequests += podMetrics.getRssRequests() * numberOfValues;

                totalValues += numberOfValues;
            }

            return weightedCpuRequests / totalValues;

        }
        else
        {
            throw new NoSuchApplicationException();
        }
    }

    @SuppressWarnings("unused")
    public double getRssLimits(String applicationName) throws NoSuchApplicationException
    {
        if(applicationMap.containsKey(applicationName))
        {
            double weightedCpuRequests = 0;
            double totalValues = 0;

            for(PodMetrics podMetrics : applicationMap.get(applicationName))
            {
                int numberOfValues = podMetrics.metricCollector.size();
                weightedCpuRequests += podMetrics.getRssLimits() * numberOfValues;

                totalValues += numberOfValues;
            }

            return weightedCpuRequests / totalValues;
        }
        else
        {
            throw new NoSuchApplicationException();
        }
    }
}
